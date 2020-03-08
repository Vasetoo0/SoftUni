package nestedLoops;

import java.util.Scanner;

public class EqualSumsLeftRightPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (;num1 <= num2; num1++) {
            String num1Str = Integer.toString(num1);

            int leftSum = 0;
            int rightSum = 0;

            int num = 0;
            int midNum = 0;


            for (int i = 0; i <= num1Str.length() - 1; i++) {
                if (i < 2) {
                    num = num1Str.charAt(i) - 48;
                    leftSum += num;
                } else if (i > 2) {
                    num = num1Str.charAt(i) - 48;
                    rightSum += num;
                } else {
                    num = num1Str.charAt(i) - 48;
                    midNum = num;
                }
            }
            if (rightSum == leftSum) {
                System.out.print(num1);
                System.out.print(" ");
            } else if (leftSum < rightSum) {
                leftSum += midNum;
                if (leftSum == rightSum) {
                    System.out.print(num1);
                    System.out.print(" ");
                }
            } else {
                rightSum += midNum;
                if (rightSum == leftSum) {
                    System.out.print(num1);
                    System.out.print(" ");
                }

            }

        }

    }
}
