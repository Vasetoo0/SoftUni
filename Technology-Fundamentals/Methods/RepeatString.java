package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(newText(text, n));

    }

    static String newText(String text, int n) {

        String newString = "";

        for (int i = 0; i < n; i++) {
            newString += text;
        }

        return newString;
    }
}
