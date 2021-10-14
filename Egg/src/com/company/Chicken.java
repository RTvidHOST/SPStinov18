package com.company;
import java.util.Scanner;

public class Chicken {
    static Egg Option;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Option = new Egg();
        System.out.println("Начало спора");
        Option.start();
        System.out.println("Слово Яйцо было произнесено: (введите число)");
        int j = scanner.nextInt();
        for (int i = 0; i < j; i++){
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
            System.out.println("Курица");
        }
        if (Option.isAlive()){
            try {
                Option.join();
            }
            catch (InterruptedException e){}
            System.out.println("Первым было яйцо");
        }
        else {
            System.out.println("Первой была курица");
        }
        System.out.println("Спор закончен");
    }
}
