package org.example.July.DataDrivenTesting;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab056_CreateCell {
    @Test
    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Create cell at Specific Position

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("TD4");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);

        cell.setCellValue("Iron Man");

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\DIVAKAR D\\IdeaProjects\\LearningSeleniumATB6x\\ExcelFile\\Test1.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }
}
