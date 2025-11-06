package com.RealProject.RealProject.Controller;

import com.RealProject.RealProject.Services.ReportServices;
import com.RealProject.RealProject.projections.MonthReportProjection;
import com.RealProject.RealProject.projections.ReportProjection;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
@Validated
public class ReportController {
    @Autowired
    ReportServices reportServices;

    @GetMapping("/reports/{Customer_id}")
    public ResponseEntity<List<ReportProjection>> reportForMonth(@RequestParam Long customer_Id){
        List<ReportProjection> data= reportServices.reportForMonth(customer_Id);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/reports/name/{name}")
    public ResponseEntity<List<ReportProjection>> reportByName(@RequestParam String name){
        List<ReportProjection> data=reportServices.reportByName(name);
        return ResponseEntity.ok(data);
    }
    @GetMapping("report/Month/{name}")
    public ResponseEntity<List<MonthReportProjection>> monthReport(@RequestParam String name){
        List<MonthReportProjection> data = reportServices.monthReport(name);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/excel/{name}")
    public ResponseEntity<byte[]> downloadExcel(@RequestParam String name) throws IOException{
        byte[] excelData= reportServices.downloadReport(name);
        HttpHeaders headers= new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachenment").filename("Delivery_Report.xlsx").build());
        return new ResponseEntity<>(excelData,headers, HttpStatus.OK);
    }
    @GetMapping("/excel/Month/{name}")
    public ResponseEntity<byte[]> downlodeExcelMonth(@RequestParam String name) throws IOException{
        byte[] excelDataMonth= reportServices.excelMonthReport(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachenment").filename("Deliverry_Report_Month.xlsx").build());
        return new ResponseEntity<>(excelDataMonth,headers,HttpStatus.OK);
    }
    @GetMapping("/excel/allCustomer/{month}")
    public ResponseEntity<byte[]> allCustomerExcel(@RequestParam @Min(1) @Max(12) int month) throws IOException{
        byte[] excelAllCustomer=reportServices.excelAllCustomer(month);
        HttpHeaders headers =new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachenment").filename("Delevery_All_Custoner.xlsx").build());
        return new ResponseEntity<>(excelAllCustomer,headers,HttpStatus.OK);
    }
}
