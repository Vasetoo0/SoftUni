package TextAndRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyWord = reader.readLine();

        String text = reader.readLine();

        int keyIndex = text.indexOf(keyWord);

        while (keyIndex != -1) {

            //text = text.replace(keyWord, "");

          text =  text.substring(0, keyIndex) + text.substring(keyIndex + keyWord.length());
          keyIndex = text.indexOf(keyWord);
        }

        System.out.println(text);

    }

}
