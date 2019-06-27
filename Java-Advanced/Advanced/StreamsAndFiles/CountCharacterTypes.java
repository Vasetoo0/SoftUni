package Advanced.StreamsAndFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        String vowels = "aeiou";
        String punctuation = "!,.?";

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;
        try(PrintWriter writer = new PrintWriter(pathOut)) {

           List<String> lines = Files.readAllLines(Paths.get(pathIn));

            for (String line : lines) {

                for (int i = 0; i < line.length(); i++) {

                    if(line.charAt(i) != ' ') {

                        if(vowels.contains(String.valueOf(line.charAt(i)))) {
                            vowelsCount++;
                        } else if (punctuation.contains(String.valueOf(line.charAt(i)))) {
                            punctuationCount++;
                        } else {
                            consonantsCount++;
                        }
                    }
                }
            }

            writer.println(String.format("Vowels: %s", vowelsCount));
            writer.println(String.format("Consonants: %s", consonantsCount));
            writer.println(String.format("Punctuation: %s", punctuationCount));

            } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println();

    }

}
