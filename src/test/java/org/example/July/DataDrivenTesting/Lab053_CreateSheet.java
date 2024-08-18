package org.example.July.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab053_CreateSheet {
    @Test
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("TD1");

        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("UserName");
        sheet.getRow(0).createCell(1).setCellValue("Password");

        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue("Admin");
        sheet.getRow(1).createCell(1).setCellValue("Admin23");

        XSSFSheet sheet2 = workbook.createSheet("TD2");

        sheet2.createRow(0);
        sheet2.getRow(0).createCell(0).setCellValue("Email");
        sheet2.getRow(0).createCell(1).setCellValue("Password");

        sheet2.createRow(1);
        sheet2.getRow(1).createCell(0).setCellValue("Admin@gmail.com");
        sheet2.getRow(1).createCell(1).setCellValue("Admin23");



        File file = new File("C:\\Users\\DIVAKAR D\\IdeaProjects\\LearningSeleniumATB6x\\ExcelFile\\Test1.xlsx");
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

    }
}
