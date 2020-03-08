package Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(middle(input));

    }

    static String middle(String input) {

         char symbol = ' ';
         char secondSymbol = ' ';
        String midSymbols = "";
        if(input.length() % 2 == 0) {
                symbol = input.charAt((input.length() / 2) - 1);
                secondSymbol = input.charAt((input.length() / 2));
                midSymbols = "" + symbol + secondSymbol;

        } else {
            symbol = input.charAt((input.length() / 2));
            midSymbols = "" + symbol;
        }

        return midSymbols;
    }
}
