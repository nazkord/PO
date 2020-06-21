package com.nazkord;

public class Main {

    public static void main(String[] args) {
        String filePath = "/Users/nazkord/IdeaProjects/TO1/lab6/Decorator/test.txt";

        String salaryRecords = "Testowy string \n wartosc 9090909090";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource(filePath)));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource(filePath);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}