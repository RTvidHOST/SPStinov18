package com.company;
import java.util.Scanner;

public class Egg extends Thread {
    Scanner scanner = new Scanner(System.in);
    public void run(){
        System.out.println("Слово Курица было произнесено: (введите число)");
        int h = scanner.nextInt();
        for (int i = 0; i < h; i++){
            try {
                sleep(1500);
            }
            catch (InterruptedException e){}
            System.out.println("Яйцо");
        }
    }
}