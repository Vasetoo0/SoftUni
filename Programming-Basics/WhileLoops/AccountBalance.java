package whileLoops;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        double payments = 1;

        double wholeSum = 0;


        while (payments <= input) {
            double sum = Double.parseDouble(scanner.nextLine());

            if (sum < 0) {
                System.out.println("Invalid operation!");
                break;
            }

            wholeSum += sum;

            System.out.printf("Increase: %.2f%n", sum);

            payments++;

        }

        System.out.printf("Total: %.2f", wholeSum);

    }
}
