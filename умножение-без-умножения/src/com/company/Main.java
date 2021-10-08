package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число №1:");
        int a = scanner.nextInt();
        System.out.println("Введите число №2:");
        int b = scanner.nextInt();
        System.out.printf("Произведение %d", (int)Math.pow(10, (Math.log10(a) + Math.log10(b))));
    }
}