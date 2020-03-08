package Advanced.StreamsAndFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        try(FileInputStream fileInput = new FileInputStream(pathIn);
            FileOutputStream fileOutput = new FileOutputStream(pathOut)) {

            int oneByte = fileInput.read();
            String punctuation = ",.!?";
            while (oneByte >= 0) {


                if(!punctuation.contains(String.valueOf((char)oneByte))) {
                    fileOutput.write(oneByte);

                }


                oneByte = fileInput.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
