package com.kastro.lesson5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppData {

    private String[] header;
    private int[][] data;

    public void read(String pathToCsv) {
        try (BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
            header = csvReader.readLine().split(";");
            int lineCount = (int) Files.lines(Paths.get(pathToCsv)).count();
            data = new int[lineCount - 1][];
            String row;
            int currentLine = 0;
            while ((row = csvReader.readLine()) != null) {
                String[] fileData = row.split(";");
                int[] parsedData = new int[fileData.length];
                for (int i = 0; i < fileData.length; i++) {
                    parsedData[i] = Integer.parseInt(fileData[i]);
                }
                data[currentLine] = parsedData;
                currentLine++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(String pathToCsv) {
        try (PrintWriter writer = new PrintWriter(pathToCsv)) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.join(";", header));
            sb.append("\n");
            for (int i = 0; i < data.length; i++) {
                String[] stringData = new String[data[i].length];
                for (int j = 0; j < data[i].length; j++) {
                    stringData[j] = String.valueOf(data[i][j]);
                }
                sb.append(String.join(";", stringData));
                sb.append("\n");
            }

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

