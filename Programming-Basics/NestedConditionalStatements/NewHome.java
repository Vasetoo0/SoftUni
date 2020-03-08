package nestedConditionalStatements;

import java.util.Scanner;

public class NewHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerKind = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (flowerKind) {
            case "Roses":
                price = flowersCount * 5;
                break;
            case "Dahlias":
                price = flowersCount * 3.80;
                break;
            case "Tulips":
                price = flowersCount * 2.80;
                break;
            case "Narcissus":
                price = flowersCount * 3;
                break;
            default:
                price = flowersCount * 2.50;
        }

        if ("Roses".equals(flowerKind)) {
            if (flowersCount > 80) {
                price = price - (price * 0.10);
            }
        } else if ("Dahlias".equals(flowerKind)) {
            if (flowersCount > 90) {
                price = price - (price * 0.15);
            }
        } else if ("Tulips".equals(flowerKind)) {
            if (flowersCount > 80) {
                price = price - (price * 0.15);
            }
        } else if ("Narcissus".equals(flowerKind)) {
            if (flowersCount < 120) {
                price = price + (price * 0.15);
            }
        } else if ("Gladiolus".equals(flowerKind)) {
            if (flowersCount < 80) {
                price = price + (price * 0.20);
            }
        }

        double diff = Math.abs(budget - price);

        if (budget >= price) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowerKind, diff);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", diff);
        }

    }
}
