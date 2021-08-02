package com.kastro.lesson5;

public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.read("src/com/kastro/lesson5/test.csv");
        appData.write("src/com/kastro/lesson5/test2.csv");
    }
}
