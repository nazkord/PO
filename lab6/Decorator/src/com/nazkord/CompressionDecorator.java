package com.nazkord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.*;

public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] input;
        input = stringData.getBytes(StandardCharsets.UTF_8);

        // Compress the bytes
        byte[] output = new byte[input.length];
        Deflater compressor = new Deflater();
        compressor.setInput(input);
        compressor.finish();
        compressor.deflate(output);
        compressor.end();
        return new String(Base64.getEncoder().encode(output));
    }

    private String decompress(String stringData) {
        byte[] output2 = Base64.getDecoder().decode(stringData);

        // Decompress the bytes
        Inflater decompressor = new Inflater();
        decompressor.setInput(output2);
        byte[] result = stringData.getBytes();
        int resultLength = 0;
        try {
            resultLength = decompressor.inflate(result);
        } catch (DataFormatException e) {
            System.out.println(e.getMessage());
        }
        decompressor.end();

        // Decode the bytes into a String
        return new String(result, 0, resultLength, StandardCharsets.UTF_8);
    }
}
