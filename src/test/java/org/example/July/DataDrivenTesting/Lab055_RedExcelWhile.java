package org.example.July.DataDrivenTesting;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Lab055_RedExcelWhile {
    @Test
    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + "\\ExcelFile\\Test2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("TC01");

        Iterator<Row> rit = sheet.iterator();
        while (rit.hasNext()){
            Row row = rit.next();
            Iterator<Cell> cit = row.iterator();
            while (cit.hasNext()){
                Cell cell = cit.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                    System.out.print(cell.getStringCellValue());
                    break;

                    case BOOLEAN:
                    System.out.print(cell.getBooleanCellValue());
                    break;

                    case NUMERIC:
                    System.out.print(cell.getNumericCellValue());
                    break;
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        workbook.close();
    }
}
