package com.RealProject.RealProject.Utility;

import com.RealProject.RealProject.projections.MonthReportProjection;
import com.RealProject.RealProject.projections.ReportProjection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelGenerator {
    public static byte[] generateReport(Map<String,Object> reports) throws IOException{
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet = workbook.createSheet((reports.get("SheetName").toString()));
        Row headerRow = sheet.createRow(0);
        List<String> headers=(List<String>)reports.get("Headers");
        for(int i=0;i<headers.size();i++){
            Cell cell=headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
        }
        int rowIndex=1;
        List<?> rep=(List<?>)reports.get("ReportList");
        for(int i=0;i<rep.size();i++){
            var report=rep.get(i);
            if(report instanceof ReportProjection r){
                Row row=sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(r.getName());
                row.createCell(1).setCellValue(String.valueOf(r.getDeliveryDate()));
                row.createCell(2).setCellValue(r.getnumOfCans());
            }
            else if(report instanceof MonthReportProjection mr){
                Row row=sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(mr.getName());
                row.createCell(1).setCellValue(mr.getMonth());
                row.createCell(2).setCellValue(mr.getTotalCans());
            }
        }
        //AutoSize Columns
        for(int i=0;i<headers.size();i++){
            sheet.autoSizeColumn(i);
        }
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}
