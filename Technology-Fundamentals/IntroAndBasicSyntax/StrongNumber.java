package IntroAndBasicSyntax;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumber = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < inputNumber.length(); i++) {
            int num = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));

            int factorial = 1;
            for (int j = 1; j <= num; j++) {
                factorial *= j;
            }

            sum += factorial;
        }

        System.out.println(inputNumber.equals(String.valueOf(sum)) ? "yes" : "no");
    }
}
