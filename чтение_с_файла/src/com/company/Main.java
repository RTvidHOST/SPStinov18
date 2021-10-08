package com.company;

import java.lang.Math;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader file = new BufferedReader(new FileReader("умножение.txt"))) {
            String str = file.readLine();
            String[] values = str.split("\\*");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            System.out.print("\n" + Math.pow(10, (Math.log10(a) + Math.log10(b))));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}