package Advanced.StreamsAndFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        try (FileInputStream fis = new FileInputStream(pathIn);
             FileOutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                if(oneByte == 32 || oneByte == 10) {
                    fos.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fos.write(digits.charAt(i));
                    }

                }
                oneByte = fis.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
