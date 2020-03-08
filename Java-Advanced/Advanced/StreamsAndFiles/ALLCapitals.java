package Advanced.StreamsAndFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCapitals {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)) {

            String line = reader.readLine();



                while (line != null) {
                    writer.println(line.toUpperCase());
                    line  =  reader.readLine();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
