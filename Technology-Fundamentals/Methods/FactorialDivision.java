package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long firstNumber = Long.parseLong(scanner.nextLine());
        long secondNumber = Long.parseLong(scanner.nextLine());

        double result = factorial(firstNumber) / factorial(secondNumber);

        System.out.printf("%.2f", result);



    }

    static double factorial(double number) {


        if (number == 0) {
            return 1;
        } else {
            return (number * factorial(number - 1));
        }

    }

//    static double factorial(double number) {
//
//        int factorielNumber = 1;
//        if (number == 0) {
//            return factorielNumber;
//        } else {
//
//            for (int i = 1; i <= number; i++) {
//                factorielNumber *= i;
//            }
//            return factorielNumber;
//        }
//    }
}
