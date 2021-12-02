package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MP3 {
    private static final String DATA_FILE = "C:\\play_music_and_download\\src\\com\\company\\source.txt"; // константа, содержащая путь к файлу
    @Method
    public static void main(String[] args) {
        try (BufferedReader BRDataFile = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            String[] data;
            while ((line = BRDataFile.readLine()) != null) { // старт потока скачивания
                data = line.split(" ");
                new Main(data[0], data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
