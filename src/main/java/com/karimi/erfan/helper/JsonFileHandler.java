package com.karimi.erfan.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonFileHandler {
    private final String filePath;

    public JsonFileHandler(String filePath) {
        this.filePath = filePath;
        createFileIfNotExists();
    }

    private void createFileIfNotExists() {
        try {
            File file = new File(filePath);
            file.createNewFile();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<String> readAllLines() {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return new ArrayList<>();
    }

    public void writeJsonToFile(String json) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(json);
            bufferedWriter.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}