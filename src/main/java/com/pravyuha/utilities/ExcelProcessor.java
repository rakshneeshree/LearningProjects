package com.pravyuha.utilities;



import java.io.*;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelProcessor {

    FileInputStream fileInputStream;
    XSSFWorkbook xssfWorkbook;
    Sheet sheet;
    Row row;

    public void readWorkbook(String path) throws IOException {
        fileInputStream = new FileInputStream(path);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
    }

    public void readSheet(String name) {
        sheet = xssfWorkbook.getSheet(name);
    }

    public Row readRow(int index) {
        row = sheet.getRow(index);


        return row;
    }

    public void deleteRow(){
        row.removeCell(row.getCell(2));

    }

    InputStream inputStream = null;
    Workbook workbook = null;
    OutputStream outputStream = null;

    public void createSheet(String path, String sheetname) {

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.createSheet(sheetname);

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(2);
            cell.setCellValue("Test New Cell");
            Cell cell1 = row.createCell(5);
            cell1.setCellValue("Test New Cell");

            outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeSheet(String path, int sheetIndex) {

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);

            workbook.removeSheetAt(sheetIndex);

            outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



