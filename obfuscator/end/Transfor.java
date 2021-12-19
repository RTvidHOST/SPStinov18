package end;  import com.company.Main;

import java.io.*; import java.util.regex.Matcher; import java.util.regex.Pattern;  public class Transfor { public static String transformLink(byte num){ try(BufferedReader read = new BufferedReader(new FileReader(Main.INFO_TXT))){ String line; String link = ""; while ((line = read.readLine()) != null){ if (num == 1){