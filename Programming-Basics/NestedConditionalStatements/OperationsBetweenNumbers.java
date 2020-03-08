package nestedConditionalStatements;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        int result = 0;


        if ("+".equals(operator)) {
            result = N1 + N2;
            if (result % 2 == 0) {
                System.out.printf("%d + %d = %d - even", N1, N2, result);
            } else {
                System.out.printf("%d + %d = %d - odd", N1, N2, result);
            }
        } else if ("-".equals(operator)) {
            result = N1 - N2;
            if (result % 2 == 0) {
                System.out.printf("%d - %d = %d - even", N1, N2, result);
            } else {
                System.out.printf("%d - %d = %d - odd", N1, N2, result);
            }
        } else if ("*".equals(operator)) {
            result = N1 * N2;
            if (result % 2 == 0) {
                System.out.printf("%d * %d = %d - even", N1, N2, result);
            } else {
                System.out.printf("%d * %d = %d - odd", N1, N2, result);
            }
        } else if ("/".equals(operator)) {
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                double result1 = (double)N1 /(double)N2;
                System.out.printf("%d / %d = %.2f", N1, N2, result1);
            }
        } else if ("%".equals(operator)) {
            if (N2 == 0) {
                System.out.printf("Cannot divide %d by zero", N1);
            } else {
                result = N1 % N2;
                System.out.printf("%d %% %d = %d", N1, N2, result);
            }
        }
    }
}
