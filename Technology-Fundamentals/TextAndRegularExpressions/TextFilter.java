package TextAndRegularExpressions;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

            for (String bannedWord : bannedWords) {

                StringBuilder replacement = new StringBuilder();

                for (int j = 0; j < bannedWord.length(); j++) {

                    replacement.append("*");
                }

                text = text.replace(bannedWord, replacement);
            }

        System.out.println(text);

    }

}
