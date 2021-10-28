package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //Последовательное копирование файлов
        Path TEST1 = Paths.get("D:\\Test\\111\\345.txt"); //Путь к файлу, который нужно скопировать
        Path TEST2 = Paths.get("D:\\Test\\111\\555\\345.txt"); //Путь к файлу, куда нужно скопировать
        Path TEST3 = Paths.get("D:\\Test\\111\\111.txt"); //Путь к файлу, который нужно скопировать
        Path TEST4 = Paths.get("D:\\Test\\111\\555\\111.txt"); //Путь к файлу, куда нужно скопировать

        try {
            Files.copy(TEST1, TEST2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(TEST3, TEST4, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Копирование атрибутов файла
    }

    public static void PosCopy() throws InterruptedException {
        //Последовательное копирование файлов
        Path TEST1 = Paths.get("D:\\Test\\111\\345.txt"); //Путь к файлу, который нужно скопировать
        Path TEST2 = Paths.get("D:\\Test\\111\\555\\345.txt"); //Путь к файлу, куда нужно скопировать
        Path TEST3 = Paths.get("D:\\Test\\111\\111.txt"); //Путь к файлу, который нужно скопировать
        Path TEST4 = Paths.get("D:\\Test\\111\\555\\111.txt"); //Путь к файлу, куда нужно скопировать

        try {
            Files.copy(TEST1, TEST2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(TEST3, TEST4, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Копирование атрибутов файла
    }
    public static void ParCopy() throws InterruptedException {
        //Параллельное копирование фалов
        String test1 = "D:\\Test\\222\\777.txt";
        String test2 = "D:\\Test\\222\\333\\777.txt";
        String test3 = "D:\\Test\\222\\999.txt";
        String test4 = "D:\\Test\\222\\333\\777.txt";
        CopySt copyStream0 = new CopySt(test1, test2);
        CopySt copyStream1 = new CopySt(test3, test4);
        copyStream0.start();
        copyStream1.start();
    }
}