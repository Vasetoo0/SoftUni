package nestedConditionalStatements;

import java.util.Scanner;

public class Holiday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        ;
        String season = scanner.nextLine();

        double price = 0.0;
        String placeForRest = "";

        if (budget <= 100) {
            System.out.println("Somewhere in Bulgaria");
            if ("summer".equals(season)) {
                placeForRest = "Camp";
                price = budget - (budget * 0.30);
            } else {
                placeForRest = "Hotel";
                price = budget - (budget * 0.70);
            }
        } else if (budget <= 1000) {
            System.out.println("Somewhere in Balkans");
            if ("summer".equals(season)) {
                placeForRest = "Camp";
                price = budget - (budget * 0.40);
            } else {
                placeForRest = "Hotel";
                price = budget - (budget * 0.80);
            }
        } else {
            System.out.println("Somewhere in Europe");
            placeForRest = "Hotel";
            price = budget - (budget * 0.90);
        }

        price = budget - price;

        System.out.printf("%s - %.2f", placeForRest , price);

    }
}
