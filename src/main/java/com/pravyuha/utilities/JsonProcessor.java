package com.pravyuha.utilities;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
public class JsonProcessor {
    private final ObjectMapper objectMapper;
    public JsonProcessor(){
        this.objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public JsonNode readJson(String path) throws IOException {
        return objectMapper.readTree(new File(path));
    }

    public void writeJson(String path, JsonNode node) throws IOException {
        objectMapper.writeValue(new File(path),node);
    }
    public void updateJson(String path, String fieldName, String fieldValue) throws IOException {
        JsonNode name= objectMapper.readTree(new File(path));
    }
    public void createJson(String path, JsonNode node) throws IOException {
        objectMapper.writeValue(new File(path),node);
    }

    public void createNewJson(String path,String string) throws IOException {
        JsonNode node=objectMapper.readTree(string);
        createJson(path,node);
    }

}

