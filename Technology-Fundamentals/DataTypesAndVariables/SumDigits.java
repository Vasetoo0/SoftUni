package DataTypesAndVariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumber = scanner.nextLine();

        int sum = 0;

        for (int i = 0; i < inputNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
        }

        System.out.println(sum);


    }
}
