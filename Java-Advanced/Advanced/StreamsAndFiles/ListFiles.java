package Advanced.StreamsAndFiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {

        Path pathIn = Paths.get("F:\\Work\\Study\\Java\\Java Avanced\\Advanced\\StreamAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Path pathOut = Paths.get( "");

        File file = new File("F:\\Work\\Study\\Java\\Java Avanced\\Advanced\\StreamAndFiles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");



        if(file.isDirectory()) {

            File[] files =  file.listFiles();

            if(files != null) {

                for (File file1 : files) {
                    if(file1.isFile())
                        System.out.println(String.format("%s: [%s]",file1.getName(),file1.length()));

                }
            }
        }
    }

}
