package nestedLoops;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());


        for (; num1 <= num2; num1++) {
            String num1Str = Integer.toString(num1);
            int oddSum = 0;
            int evenSum = 0;

            for (int i = 0; i <= num1Str.length() - 1; i++) {
                if (i % 2 != 0) {
                    int oddNum = num1Str.charAt(i) - 48;
                    oddSum += oddNum;
                }
                if (i % 2 == 0) {
                    int evenNum = num1Str.charAt(i) - 48;
                    evenSum += evenNum;
                }
            }
            if (oddSum == evenSum) {
                System.out.print(num1);
                System.out.print(" ");
            }
        }
    }
}
