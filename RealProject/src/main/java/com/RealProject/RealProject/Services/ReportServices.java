package com.RealProject.RealProject.Services;

import com.RealProject.RealProject.Repository.CustomerRepo;
import com.RealProject.RealProject.Repository.DeliveryRepo;
import com.RealProject.RealProject.Utility.ExcelGenerator;
import com.RealProject.RealProject.projections.ReportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ReportServices {

    @Autowired
    DeliveryRepo reportRepo;
    @Autowired
    CustomerRepo customerRepo;



    public  List<ReportProjection>reportForMonth(Long customer_id){

        return reportRepo.monthReport(customer_id);
    }
    public List<ReportProjection>reportByName(String name){
        return reportRepo.reportByName(name);
    }
    public byte[] downloadReport(String name) throws IOException {
        List<ReportProjection> reports = reportRepo.reportByName(name);
        return ExcelGenerator.generateReport(reports);
    }
    public byte[] monthReport(String name) throws IOException{
        Long id=customerRepo.findByname(name);
        List<ReportProjection> reports=reportRepo.monthReport(name,id);
    }



}
