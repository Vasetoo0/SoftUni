package Methods;

import java.util.Scanner;

public class TribonaciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        tribonacciSequence(n);


    }

    static void tribonacciSequence(int n) {

        int[] numsRow = new int[n];

        for (int i = 0; i < n; i++) {

            if (i < 2) {
                numsRow[i] = 1;
            } else if (i == 2) {
                numsRow[i] = numsRow[i - 1] + numsRow[i - 2];
            } else {
                numsRow[i] = numsRow[i - 1] + numsRow[i - 2] + numsRow[i - 3];
            }
        }

        for (int i = 0; i < numsRow.length; i++) {
            System.out.print(numsRow[i] + " ");
        }

    }
}