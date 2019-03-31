package Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] firstRow = new String[n];
        String[] secondRow = new String[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                firstRow[i] = input[0];
                secondRow[i] = input[1];
            } else {
                firstRow[i] = input[1];
                secondRow[i] = input[0];
            }
        }
        System.out.println(String.join(" ", firstRow));
        System.out.println(String.join(" ", secondRow));

//        for (int i = 0; i < n; i++) {
//        }
//        for (int i = 0; i < n; i++) {
//        }


    }
}
