package Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            if (isPalindrome(input)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            input = scanner.nextLine();
        }

    }

    static boolean isPalindrome(String input) {

        String[] number = new String[input.length()];
        number = input.split("");

        for (int i = 0; i < number.length; i++) {
            if (!number[i].equals(number[number.length -1 - i])) {
                return false;
            }

        }
        return true;
    }
}



