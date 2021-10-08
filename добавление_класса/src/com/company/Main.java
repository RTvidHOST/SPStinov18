package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        try (BufferedReader file = new BufferedReader(new FileReader("умножение.txt"))) {
            String str = file.readLine();
            String[] values = str.split("\\*");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            Main2 main2 = new Main2();
            System.out.println(main2.Main2(a, b));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}