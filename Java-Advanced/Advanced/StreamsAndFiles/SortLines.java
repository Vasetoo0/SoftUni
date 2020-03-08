package Advanced.StreamsAndFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        Path pathIn = Paths.get(userDir + "/Resource/input.txt");
        Path pathOut = Paths.get(userDir + "/Resource/output.txt");

        try {

            List<String> lines = Files.readAllLines(pathIn);
            Collections.sort(lines);
            Files.write(pathOut, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
