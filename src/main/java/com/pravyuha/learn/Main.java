package com.pravyuha.learn;

import com.fasterxml.jackson.databind.JsonNode;
import com.pravyuha.utilities.ExcelProcessor;
import com.pravyuha.utilities.JsonProcessor;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        ExcelProcessor obj1 = new ExcelProcessor();
        String path="C:\\\\Users\\\\Rakshneeshree. B\\\\Downloads\\\\raksh.xlsx";
        obj1.readWorkbook(path);
        obj1.readSheet("Personal Details");
        Row row = obj1.readRow(2);
        System.out.println(row.getCell(1).getStringCellValue());
        obj1.createSheet(path,"EmployDetails");
        obj1.createSheet(path,"Employee");
        obj1.removeSheet(path,2);



        JsonProcessor obj2 = new JsonProcessor();

        String jsonpath = "C:\\Users\\Rakshneeshree. B\\Downloads\\StudentJson.json";

        try {
            JsonNode node = obj2.readJson(jsonpath);
            System.out.println(node);

            String fieldName = "name";
            String fieldValue = "Rakshnee";
            obj2.updateJson(jsonpath, fieldName, fieldValue);
            System.out.println(obj2.readJson(jsonpath));


            String newpath = "C:\\Users\\Rakshneeshree. B\\Downloads\\Studentnew.json";
            JsonNode newnode = obj2.readJson(jsonpath);
            obj2.createJson(newpath, newnode);
            String outpath = "C:\\Users\\Rakshneeshree. B\\Downloads\\Jsonoutput.json";

            obj2.writeJson(outpath, node); System.out.println("Project successfully done");

        }
        catch(IOException e){
            e.printStackTrace();
        }




    }


    }


