package TextAndRegularExpressions;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String file = scanner.nextLine();

        file = file.substring(file.lastIndexOf("\\") + 1);

        String fileName = file.substring(0,file.lastIndexOf("."));
        String fileExtension = file.substring(file.lastIndexOf(".") + 1);

        System.out.printf("File name: %s%n",fileName);
        System.out.printf("File extension: %s",fileExtension);
    }

}
