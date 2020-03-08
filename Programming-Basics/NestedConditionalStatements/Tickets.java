package nestedConditionalStatements;

import java.util.Scanner;

public class Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int peopleCount = Integer.parseInt(scanner.nextLine());

        double transportPrice = 0;

        if (peopleCount >= 1 && peopleCount <= 4) {
            transportPrice = budget * 0.75;
        } else if (peopleCount >= 5 && peopleCount <= 9) {
            transportPrice = budget * 0.60;
        } else if (peopleCount >= 10 && peopleCount <= 24) {
            transportPrice = budget * 0.50;
        } else if (peopleCount >= 25 && peopleCount <= 49) {
            transportPrice = budget * 0.40;
        } else {
            transportPrice = budget * 0.25;
        }

        double moneyForTickets = 0;

        switch (ticketType) {
            case "VIP":
                moneyForTickets = peopleCount * 499.99;
                break;
            case "Normal":
                moneyForTickets = peopleCount * 249.99;
                break;
        }

        double restMoney = budget - transportPrice;
        double diff = Math.abs(restMoney - moneyForTickets);

        if (restMoney >= moneyForTickets) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }

    }
}
