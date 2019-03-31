package nestedLoops;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();


        double sum = 0;

        while (!destination.equals("End")) {

            double minBudget = Double.parseDouble(scanner.nextLine());

            while (sum < minBudget) {
                double savedMoney = Double.parseDouble(scanner.nextLine());
                sum += savedMoney;
                if (sum >= minBudget) {
                    System.out.printf("Going to %s!", destination);
                }
            }

            System.out.println();

            sum = 0;

            destination = scanner.nextLine();

        }

    }
}
