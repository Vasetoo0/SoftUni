package Advanced.StreamsAndFiles;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/Resource/input.txt";
        String pathOut = userDir + "/Resource/output.txt";

        int count = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
            BufferedWriter writer  = new BufferedWriter (new PrintWriter(pathOut))) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                if(count % 3 == 0) {
                    writer.write(line);
                    writer.newLine();
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
