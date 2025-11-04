package com.RealProject.RealProject.Utility;

import com.RealProject.RealProject.projections.ReportProjection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    public static byte[] generateReport(List<ReportProjection> reportList) throws IOException{
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Delevery Report");


        Row headerRow = sheet.createRow(0);
        String[] headers ={"Customer Name","Delivery Date","Number Of Cans"};
        for(int i=0;i<headers.length;i++){
            Cell cell=headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowIndex=1;
        for(ReportProjection report:reportList){
            Row row=sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(report.getName());
            row.createCell(1).setCellValue(String.valueOf(report.getDeliveryDate()));
            row.createCell(2).setCellValue(report.getnumOfCans() != null?report.getnumOfCans():0);
        }


        //AutoSize Columns
        for(int i=0;i<headers.length;i++){
            sheet.autoSizeColumn(i);
        }
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}
