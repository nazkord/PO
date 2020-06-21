package com.nazkord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataSource implements DataSource {
    private String filePath;

    public FileDataSource(String name) {
        this.filePath = name;
    }

    @Override
    public void writeData(String data) {
        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
