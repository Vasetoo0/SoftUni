package Advanced.StreamsAndFiles;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class NestedFolder {
    public static void main(String[] args) {

       File root = new File("E:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedDirs = current.listFiles();

            for (File nestedDir : nestedDirs) {
                if(nestedDir.isDirectory()) {
                    dirs.offer(nestedDir);

                }
            }

            count++;
            System.out.println(current.getName());
        }

        System.out.println(count + " folders");


//       DFS(root);

    }

//    static void DFS(File root) {
//
//        if(root == null) {
//            return;
//        }
//
//        File[] files = root.listFiles();
//        if(files == null) {
//            return;
//        }
//
//        for (File file : files) {
//
//            if(file.isDirectory()) {
//                System.out.println(file.getName());
//                DFS(file);
//
//            }
//        }
//    }

}
