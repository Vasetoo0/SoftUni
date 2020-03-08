package IntroAndBasicSyntax;

import java.util.Scanner;

public class lastDigitName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char lastDigit = '0';

        for (int i = 0; i < input.length(); i++) {
            if (i == input.length()-1) {
                lastDigit = input.charAt(i);
            }
        }

        if (lastDigit == '1') {
            System.out.println("one");
        } else if (lastDigit  == '2') {
            System.out.println("two");
        } else if (lastDigit  == '3') {
            System.out.println("three");
        } else if (lastDigit  == '4') {
            System.out.println("four");
        } else if (lastDigit  == '5') {
            System.out.println("five");
        } else if (lastDigit  == '6') {
            System.out.println("six");
        } else if (lastDigit  == '7') {
            System.out.println("seven");
        } else if (lastDigit  == '8') {
            System.out.println("eight");
        } else if (lastDigit  == '9') {
            System.out.println("nine");
        } else if (lastDigit == '0') {
            System.out.println("zero");
        }

    }
}
