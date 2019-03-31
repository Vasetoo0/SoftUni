package nestedConditionalStatements;

import java.util.Scanner;

public class BoatHire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermenCount = Integer.parseInt(scanner.nextLine());

        double shipPrice = 0.0;

        if (fishermenCount <= 6) {
            if ("Spring".equals(season)) {
                shipPrice = 3000 - (3000 * 0.10);
            } else if ("Summer".equals(season) || "Autumn".equals(season)) {
                shipPrice = 4200 - (4200 * 0.10);
            } else {
                shipPrice = 2600 - (2600 * 0.10);
            }
        } else if (fishermenCount <= 11) {
            if ("Spring".equals(season)) {
                shipPrice = 3000 - (3000 * 0.15);
            } else if ("Summer".equals(season) || "Autumn".equals(season)) {
                shipPrice = 4200 - (4200 * 0.15);
            } else {
                shipPrice = 2600 - (2600 * 0.15);
            }
        } else {
            if ("Spring".equals(season)) {
                shipPrice = 3000 - (3000 * 0.25);
            } else if ("Summer".equals(season) || "Autumn".equals(season)) {
                shipPrice = 4200 - (4200 * 0.25);
            } else {
                shipPrice = 2600 - (2600 * 0.25);
            }
        }

        if (fishermenCount % 2 == 0 && !"Autumn".equals(season)) {
            shipPrice = shipPrice - (shipPrice * 0.05);
        }

        double diff = Math.abs(budget - shipPrice);

        if (budget >= shipPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
