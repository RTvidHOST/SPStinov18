package com.company;

public class Main {

    public static final String INFO_TXT = "C:\\play_music\\src\\com\\company\\downloadmusic\\inFile.txt"; // Файл с ссылками на сайты и пути сохранения
    public static final String OUT_TXT = "out.txt"; // Файл для вывода
    public static final String INFO_MUSIC_TXT = "infoMusic.txt"; // Файл для ссылки музыки
    public static final String INFO_PICTURE_TXT = "infoPicture.txt"; // Файл дял ссылки картинки

    public static void main(String[] args) {
        Stream  music = (new Stream("music"));
        Stream picture = (new Stream("picture"));
        music.start(); //Запуск потока скачивания mp3 файла
        picture.start(); //Запусак потока скачивания jpg файла
        while (true){
            if (!picture.isAlive()){ // Проверяет, скачались ли песня и картинки
                System.out.println("jpg файл скачен");
                break;
            }
        }
        while (true){
            if (!music.isAlive()){
                System.out.println("mp3 файл скачен");
                break;
            }
        }
        while (true){

            if (!music.isAlive() && !picture.isAlive()){ // Проверяет, скачались ли песня и картинки
                System.out.println("Идёт запуск музыки");
                MP3Player.MP3(); // открывает метод для заупска песни
                break;
            }
        }

    }

}