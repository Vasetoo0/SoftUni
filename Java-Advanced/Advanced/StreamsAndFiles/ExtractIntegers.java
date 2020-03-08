package Advanced.StreamsAndFiles;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(pathIn));
             PrintWriter printOtput = new PrintWriter(pathOut)) {

            while (scanner.hasNext()) {
                if(scanner.hasNextInt()) {

                    printOtput.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
