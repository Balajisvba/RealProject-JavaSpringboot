package com.RealProject.RealProject.Services;

import com.RealProject.RealProject.Repository.CustomerRepo;
import com.RealProject.RealProject.Repository.DeliveryRepo;
import com.RealProject.RealProject.Utility.ExcelGenerator;
import com.RealProject.RealProject.projections.MonthReportProjection;
import com.RealProject.RealProject.projections.ReportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ReportServices {

    @Autowired
    DeliveryRepo reportRepo;
    @Autowired
    CustomerRepo customerRepo;
    Map<String,Object> dataes=new HashMap<String,Object>();



    public  List<ReportProjection>reportForMonth(Long customer_id){

        return reportRepo.monthReport(customer_id);
    }
    public List<ReportProjection>reportByName(String name){
        return reportRepo.reportByName(name);
    }

    public List<MonthReportProjection> monthReport(String name){
        return reportRepo.excelmonthReport(name);
    }
    public byte[] excelMonthReport(String name) throws IOException{
        List<MonthReportProjection> reports=reportRepo.excelmonthReport(name);
        List<String> repfforMonth= Arrays.asList("Customer Name","Delivery Month","Total Cans");
        dataes.put("Headers",repfforMonth);
        dataes.put("SheetName","MonthReports");
        dataes.put("ReportList",reports);
        return ExcelGenerator.generateReport(dataes);
    }
    public byte[] downloadReport(String name) throws IOException {
        List<ReportProjection> reports = reportRepo.reportByName(name);
        List<String> repForDelivery=Arrays.asList("Customer Name","Delivery Date","No Of Cans");
        dataes.put("Headers",repForDelivery);
        dataes.put("SheetName","Delevery Reports");
        dataes.put("ReportList",reports);
        return ExcelGenerator.generateReport(dataes);
    }



}
