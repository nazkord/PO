package com.nazkord;

public interface DataSource {
    void writeData(String data);
    String readData();
}
