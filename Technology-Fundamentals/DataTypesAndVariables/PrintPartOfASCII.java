package DataTypesAndVariables;

import java.util.Scanner;

public class PrintPartOfASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startChar = Integer.parseInt(scanner.nextLine());
        int stopChar = Integer.parseInt(scanner.nextLine());


        for (int i = startChar; i <= stopChar; i++) {
            System.out.print((char)i + " ");



        }

    }
}
