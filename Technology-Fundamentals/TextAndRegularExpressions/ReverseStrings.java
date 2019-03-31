package TextAndRegularExpressions;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = "";

        while (!"end".equals(word = scanner.nextLine())) {

            StringBuilder reversedWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }

            System.out.println(String.format("%s = %s",word, reversedWord));
        }
    }

}
