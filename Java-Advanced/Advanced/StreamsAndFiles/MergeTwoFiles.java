package Advanced.StreamsAndFiles;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstFile  = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondFile = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        String pathOut = "E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merged.txt";

        PrintWriter writer = new PrintWriter(pathOut);

        BufferedReader firstScan = new BufferedReader(new FileReader(String.valueOf(firstFile)));

        String firstTextLine = firstScan.readLine();

        while (firstTextLine != null) {

            writer.println(firstTextLine);

            firstTextLine = firstScan.readLine();
        }
        firstScan.close();

        BufferedReader secondScan = new BufferedReader(new FileReader(String.valueOf(secondFile)));

        String secondTextLine = secondScan.readLine();

        while (secondTextLine != null) {

            writer.println(secondTextLine);

            secondTextLine = secondScan.readLine();
        }
        secondScan.close();

        writer.close();
    }

}
