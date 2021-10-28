package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("D:\\Test\\345.txt");
        File dest = new File("D:\\Test\\111\\345.txt");

        // копируем файл с помощью потоков
        long start = System.nanoTime();
        // засекаем время до выполнения копирования
        copyFileUsingStream(source, dest);
        System.out.println("Время копирования файла с помощью потоков = " + (System.nanoTime() - start));
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}