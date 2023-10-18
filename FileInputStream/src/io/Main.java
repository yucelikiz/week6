package io;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String data = "Java Öğreniyorum!";

        FileWriter writerFile = null;
        try {
            writerFile = new FileWriter("output.txt");
            writerFile.write(data);
            writerFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}