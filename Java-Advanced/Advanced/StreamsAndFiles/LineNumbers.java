package Advanced.StreamsAndFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {

        Path pathIn = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        String pathOut = "E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";

        try(PrintWriter writer = new PrintWriter(pathOut)) {

            List<String> lines = Files.readAllLines(pathIn);

            int lineCount = 1;

            for (String line : lines) {

                writer.println(String.format("%s. %s", lineCount, line));
                lineCount++;
            }



        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println();
    }

}
