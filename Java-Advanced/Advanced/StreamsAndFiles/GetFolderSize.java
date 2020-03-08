package Advanced.StreamsAndFiles;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) {

        Path mainFolderPath = Paths.get("E:\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        File mainFolder = new File(String.valueOf(mainFolderPath));

        File[] files = mainFolder.listFiles();

        int folderSize = 0;

        for (File file : files) {
            folderSize += file.length();
        }

        System.out.println(String.format("Folder size: %s", folderSize));
    }

}
