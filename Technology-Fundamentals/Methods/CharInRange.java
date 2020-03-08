package Methods;

import java.util.Scanner;

public class CharInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstChar = scanner.nextLine();
        String secondChar = scanner.nextLine();

        System.out.print(symbolsRow(firstChar, secondChar));

    }

    static String symbolsRow(String first, String second) {

        String row = "";
        if (first.charAt(0) > second.charAt(0)) {

            for (char j = second.charAt(0); j < first.charAt(0); j++) {

                if (j > second.charAt(0)) {

                    row += j + " ";
                }
            }
        }
        for (char i = first.charAt(0); i < second.charAt(0); i++) {

            if (i > first.charAt(0)) {

                row += i + " ";
            }

            if (i == second.charAt(0)) {
                break;
            }
        }

        return row;

    }
}
