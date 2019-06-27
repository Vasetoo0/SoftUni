package Advanced.StreamsAndFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {

        Path path = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");


        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line = reader.readLine();

            long sum = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {

                    sum += c;
                }


                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
