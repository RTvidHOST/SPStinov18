package com.company;

public class Stream extends Thread {
    String name;
    public Stream(String name){
        this.name = name;
    }

    public void run(){
        Thread.currentThread().setName(name);
        if (getName().equals("music")){
            download_music.downloadMusic();
        }
        else if (getName().equals("picture")){
            download_picture.downloadPicture();
        }
    }
}
