package org.example.July.DataDrivenTesting;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Test
public class Lab052_CreateExcel {


    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Workbook
        // Sheet
        // Row, Cell
        // XSSFWorkBook - xslx > 2008
        // HSSFwORKBOOK -> xls < 2004

        // Task 1 - Create a Excel File and Add Data

        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginID", "Email", "Password"});
        data.put("2", new Object[]{"1", "Test1@email.com", "Test123"});
        data.put("3", new Object[]{"2", "Admin@gmail.com", "Test@345"});
        data.put("4", new Object[]{"3", "Admin1@gmail.com", "Tes45"});

        createExcel("TestData_1.xlsx", data);
    }


    public static String createExcel(String name, Map data) throws IOException, InvalidFormatException {
        Set<String > set = data.keySet();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");
        int rownum =0;

        for (String key : set){
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(key);
            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++);
                if ( o instanceof String){
                    cell.setCellValue((String) o);
                }
                if( o instanceof Integer){
                    cell.setCellValue((Integer)o);
                }

            }
        }


        FileOutputStream outputStream = new FileOutputStream(name);
        workbook.write(outputStream);
        outputStream.close();

        return name;
    }
}

