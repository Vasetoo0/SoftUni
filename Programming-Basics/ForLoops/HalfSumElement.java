package forLoops;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num > maxNum) {
                maxNum = num;
            }
        }

        int diff =Math.abs(maxNum - (sum - maxNum));


        if (sum - maxNum == maxNum) {
            System.out.printf("Yes Sum = %d", maxNum);
        } else {
            System.out.printf("No Diff = %d", diff);

        }

    }
}
