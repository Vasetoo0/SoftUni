package Arrays;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            int[] lastRow = new int[i];
            lastRow[0] = 1;
            int[] nextRow = new int[i];

            for (int j = 1; j <= i; j++) {

                nextRow[j] = lastRow[j] + lastRow[j+1];

                lastRow[j] = nextRow[j];
            }
            lastRow[lastRow.length-1] = 1;
        }

    }
}
