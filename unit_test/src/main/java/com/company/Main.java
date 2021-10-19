package com.company;

import java.util.Scanner;
import static com.sun.javafx.fxml.expression.Expression.multiply;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.print(multiply(scanner.nextInt(), scanner.nextInt()));
        }
    public static int mul(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (a == 1) {
            return b;
        }
        return a + mul(a, b - 1);
    }
    public static int multiply(int a, int b)
    {
        int m = mul(a, Math.abs(b));
        return (b < 0) ? -m : m;
    }
}
