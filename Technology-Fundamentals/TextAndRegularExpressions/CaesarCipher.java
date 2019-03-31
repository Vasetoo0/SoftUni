package TextAndRegularExpressions;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            encrypted.append((char)(text.charAt(i) + 3));

        }
        System.out.println(encrypted);
    }
}
