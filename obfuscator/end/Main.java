package end;  import java.io.IOException; import java.nio.file.Files; import java.nio.file.Path;  public class Main {  public static final String INFO_TXT = "C:\\play_music\\src\\com\\company\\downloadmusic\\inFile.txt"; // Ф public static final String OUT_TXT = "out.txt"; // Ф public static final String INFO_MUSIC_TXT = "infoMusic.txt"; // Ф public static final String INFO_PICTURE_TXT = "infoPicture.txt"; // Ф  public static void main(String[] args) {  Stream  music = (new Stream("music")); Stream picture = (new Stream("picture")); music.start(); //Запуск picture.start(); //Запуса while (true){ if (!picture.isAlive()){ // Проверяет System.out.println("jpg файл скачен"); break; } } while (true){ if (!music.isAlive()){ System.out.println("mp3 файл скачен"); break; } } while (true){  if (!music.isAlive() && !picture.isAlive()){ // Проверяет System.out.println("Идёт запуск музыки"); MP3Player.MP3(); // открывает мет break; } } } }