package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String str;
        String temp;
        boolean check = false;
        int ind;
        //Тут необходимо указать путь на файл, который нужно пропустить через обфускатор
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\music\\src\\com\\company\\Main.txt"));
             //Тут путь, куда пропущеный через обфускатор файл нужно закинуть, а так же название файла
             FileWriter fw = new FileWriter("C:\\music\\src\\com\\company\\Main.java")) {
            while ((str = br.readLine()) != null) {
                if (str.startsWith("/*")) { //Начало  многострочного комментария
                    check = true;
                    continue;
                }
                if (check & !str.contains("*/")) { //Если комментарий многострочный, то пропуск строк
                    continue;
                }
                if (check & str.endsWith("*/")) { //Конец многострочного комментария
                    check = false;
                    continue;
                }
                if (!str.contains("//") & !str.contains("*/") & !str.contains("*/")) { // не комментарии
                    str = str.trim();
                    fw.write(str + " ");
                } else {
                    ind = str.lastIndexOf("//"); //Удаление однострочных комментариев
                    if (ind == 0){
                        continue;
                    }
                    if (str.contains(" ")) { //Удаление пробелов
                        str = str.trim();
                    }
                    if (str.chars().allMatch(Character::isWhitespace)){ //Строки с пробелами
                        continue;
                    }
                    if (ind > 0 & ind + 3 != str.indexOf(")")) { //Запись строки с комментарием
                        temp = str.substring(0, ind);
                        temp = temp.trim();
                        fw.write(temp + " ");
                    } else {
                        str = str.trim();
                        fw.write(str + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}