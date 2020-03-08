package DataTypesAndVariables;

import java.util.Scanner;

public class RefactorSpecialNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int num = 0;
        boolean isTrue = false;
        for (int i = 1; i <= n; i++) {
            num = i;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = i;
            if (isTrue = (sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> True%n", num);

            } else {
                System.out.printf("%d -> False%n", num);
            }

            sum = 0;
            //i = num;
        }

    }
}
