package com.company;

import java.io.IOException;
import java.nio.file.*;
public class CopySt extends Thread {
    public final String CopyPathSt;
    public final String PastePathSt;
    CopySt(String CopyPathSt1, String PastePathSt1){
        this.CopyPathSt = CopyPathSt1;
        this.PastePathSt = PastePathSt1;
    }

    public void run(){
        Path CopyPath1 = Paths.get("D:\\Test\\222\\777.txt");
        Path PastePathSt1 = Paths.get("D:\\Test\\222\\333\\777.txt");
        try {
            Files.copy(CopyPath1, PastePathSt1, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}