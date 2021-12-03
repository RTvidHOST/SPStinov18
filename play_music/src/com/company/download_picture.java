package com.company;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class download_picture {

    @Help
    public static void downloadPicture() {
        byte num = 1;
        String link = Transfor.transformLink(num);
        String path = Transfor.transformPath(num);
        Transfor.write(link, num);
        String Url;


        try (BufferedReader inFile = new BufferedReader(new FileReader(Main.INFO_PICTURE_TXT));
             BufferedWriter outFile = new BufferedWriter(new FileWriter(Main.OUT_TXT))) {

            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);
                String result;

                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    result = bufferedReader.lines().collect(Collectors.joining("\n"));
                }

                Pattern email_pattern = Pattern.compile("\\s*(?<=src\\s?=\\s?\")[^>]*\\/*\\.(jpeg|jpg|png)(?=\")");
                Matcher matcher = email_pattern.matcher(result);
                int i = 0;

                while (matcher.find() && i < 1) {
                    outFile.write(matcher.group() + "\r\n");
                    i++;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader pictureFile = new BufferedReader(new FileReader(Main.OUT_TXT))) {
            String picture;
            int count = 0;
            try {
                while ((picture = pictureFile.readLine()) != null) {
                    assert path != null;
                    downloadUsingNIO(picture, path.trim() + String.valueOf(count) + ".jpg");
                    count++;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL url = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}