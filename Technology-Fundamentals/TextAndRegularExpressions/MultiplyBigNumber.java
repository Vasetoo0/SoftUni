package TextAndRegularExpressions;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNumber = scanner.nextLine();
        int multiplyNumber = Integer.parseInt(scanner.nextLine());

        StringBuilder currentResult = new StringBuilder();

        if (multiplyNumber == 0) {
            currentResult.append("0");
            return;
        }
        int rest = 0;

        int reminder = 0;

        int result = 0;

        for (int i = bigNumber.length() - 1; i >= 0; i--) {

            if (currentResult.length() == 0) {
                result = Integer.parseInt(String.valueOf(bigNumber.charAt(i))) * multiplyNumber;
                currentResult.append(result);
                if (result >= 10) {
                    rest = result / 10;
                }
            } else {
                result = Integer.parseInt(String.valueOf(bigNumber.charAt(i))) * multiplyNumber;
                if (rest > 0) {
                    if (result > 10) {
                        reminder = (result % 10) + Integer.parseInt(String.valueOf(currentResult.charAt(0)));
                        rest = result / 10;
                        if (reminder >= 10) {
                            rest += reminder / 10;
                            currentResult = new StringBuilder("" + rest + (reminder % 10) + currentResult.substring(1));
                        } else {
                            currentResult = new StringBuilder("" + rest + reminder + currentResult.substring(1));
                        }
                    } else {
                        reminder = result + Integer.parseInt(String.valueOf(currentResult.charAt(0)));
                        if (reminder > 10) {
                            rest = reminder / 10;
                            currentResult = new StringBuilder("" + rest + (reminder % 10) + currentResult.substring(1));
                        } else {
                            currentResult = new StringBuilder(reminder + currentResult.substring(1));
                            rest = 0;
                        }
                    }
                } else {
                    currentResult = new StringBuilder("" + result + currentResult);
                    if (result >= 10) {
                        rest = result / 10;
                    }
                }
            }
        }
        System.out.println(currentResult);
    }
}
