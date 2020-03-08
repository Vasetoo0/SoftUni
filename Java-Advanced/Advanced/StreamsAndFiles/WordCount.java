package Advanced.StreamsAndFiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

         Path keyWordsPath = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
         Path matchTextPath = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        BufferedReader keyWordRead = new BufferedReader(new FileReader(String.valueOf(keyWordsPath)));

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        String[] words = keyWordRead.readLine().split(" ");

        for (String word : words) {
            wordsCount.putIfAbsent(word, 0);
        }

        Scanner scanner = new Scanner(new FileInputStream(String.valueOf(matchTextPath)));

        while (scanner.hasNext()) {
            String word = scanner.next();

            if(wordsCount.containsKey(word)) {
                wordsCount.put(word,wordsCount.get(word) + 1);
            }

        }
        PrintWriter writer = new PrintWriter("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");

        wordsCount.entrySet().stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue(),c1.getValue()))
                .forEach(e -> {

                       writer.println(String.format("%s - %s", e.getKey(), e.getValue()));

                });
        writer.close();

    }

}
