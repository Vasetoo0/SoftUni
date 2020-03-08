package nestedLoops;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!"stop".equalsIgnoreCase(input)) {
            int num = Integer.parseInt(input);

            boolean isPrime = true;
            int temp;

            for (int i = 2; i <= num / 2; i++) {
                temp = num % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (num < 0) {
                System.out.println("Number is negative.");
            } else if (num == 1) {
                nonPrimeSum += num;
            } else if (isPrime) {
                primeSum += num;
            } else {
                nonPrimeSum += num;
            }

            input = scanner.nextLine();

        }

        System.out.printf("Sum of all prime numbers is: %d%n", (long)primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", (long)nonPrimeSum);


    }
}
