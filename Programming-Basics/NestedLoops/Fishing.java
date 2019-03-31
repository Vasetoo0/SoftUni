package nestedLoops;

import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dailyQuote = Integer.parseInt(scanner.nextLine());
        //String fishName = scanner.nextLine();


        double paySum = 0;
        double getSum = 0;
        int dailyQuoteCount = 0;

        for (int i = 1; i <= dailyQuote; i++) {
            String  fishName = scanner.nextLine();
            if ("Stop".equals(fishName)) {
                break;
            }
            double fishKg = Double.parseDouble(scanner.nextLine());
            int asciiSum = 0;

            if (i % 3 == 0) {
                for (int j = 0; j < fishName.length(); j++) {
                    int symbol = fishName.charAt(j);
                    asciiSum += symbol;
                }
                double sum = asciiSum / fishKg;
                getSum += sum;
            } else {
                for (int g = 0; g < fishName.length(); g++) {
                    int symbol = fishName.charAt(g);
                    asciiSum += symbol;
                }
                double sum = asciiSum / fishKg;
                paySum += sum;
            }

            dailyQuoteCount++;

        }

        double diff = Math.abs(getSum - paySum);



        if (dailyQuoteCount == dailyQuote) {
            System.out.println("Lyubo fulfilled the quota!");
            if (paySum > getSum) {
                System.out.printf("Lyubo lost %.2f leva today.", diff);
            } else {
                System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", dailyQuoteCount, diff);
            }

        } else {
            if (paySum > getSum) {
                System.out.printf("Lyubo lost %.2f leva today.", diff);
            } else {
                System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", dailyQuoteCount, diff);
            }
        }

    }
}
