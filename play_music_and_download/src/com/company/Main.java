package com.company;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main extends Thread{
    private final String link;
    private final String path;
    private static int threadCounter;
    @Constructor(forClass = "downloadThreads")
    Main(String link, String path) {
        this.link = link;
        this.path = path;
        this.start();
    }

    @Override
    public void run() {
        try { // создание пустого mp3 файла
            File f = new File("C:\\play_music_and_download\\src\\com\\company\\mp.mp3");
            if (f.createNewFile())
                System.out.println("Файл создан!");
        }
        catch (Exception e) {
            System.err.println(e);
        }
        try (FileInputStream inputStream = new FileInputStream("C:\\play_music_and_download\\src\\com\\company\\mp.mp3")) {
            // ссылка на файл для вопсроизведения
            System.out.println("Загружка началась: " + path);
            URL url = new URL(link);
            ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
            FileOutputStream stream = new FileOutputStream(path);
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            stream.close();
            byteChannel.close();
            System.out.println("Загрузка завершена: " + path);
            threadCounter++;
            if (threadCounter == 2) {
                System.out.println("Музыка включилась");
                Player player = new Player(inputStream);
                player.play(); // непосредственно включение музыки
            }
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}