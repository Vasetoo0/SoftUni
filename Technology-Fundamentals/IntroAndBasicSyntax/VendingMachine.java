package IntroAndBasicSyntax;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double coinsSum = 0;

        while (!"Start".equals(input)) {
            double coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                coinsSum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }

            input = scanner.nextLine();
        }

        while (!"End".equals(input)) {
            input = scanner.nextLine();

            if ("Nuts".equals(input)) {
                if (coinsSum < 2.0) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Nuts");
                    coinsSum -= 2.0;
                }

            } else if ("Water".equals(input)) {
                if (coinsSum < 0.7) {
                    System.out.println("Sorry, not enough money");

                } else {
                    System.out.println("Purchased Water");
                    coinsSum -= 0.7;
                }

            } else if ("Crisps".equals(input)) {
                if (coinsSum < 1.5) {
                    System.out.println("Sorry, not enough money");

                } else {
                    System.out.println("Purchased Crisps");
                    coinsSum -= 1.5;
                }

            } else if ("Soda".equals(input)) {
                if (coinsSum < 0.8) {
                    System.out.println("Sorry, not enough money");

                } else {
                    System.out.println("Purchased Soda");
                    coinsSum -= 0.8;
                }

            } else if ("Coke".equals(input)) {
                if (coinsSum < 1.0) {
                    System.out.println("Sorry, not enough money");

                } else {
                    System.out.println("Purchased Coke");
                    coinsSum -= 1.0;
                }

            } else if (!"End".equals(input)){
                System.out.println("Invalid product");

            }
        }

        System.out.printf("Change: %.2f", coinsSum);
    }
}
