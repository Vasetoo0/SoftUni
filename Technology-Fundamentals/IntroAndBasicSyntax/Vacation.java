package IntroAndBasicSyntax;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double totalPrice = 0;

        if ("Students".equals(groupType)) {
            switch (dayOfWeek) {
                case "Friday":
                    totalPrice = groupCount * 8.45;
                    break;
                case "Saturday":
                    totalPrice = groupCount * 9.80;
                    break;
                case "Sunday":
                    totalPrice = groupCount * 10.46;
                    break;
            }

            if (groupCount >= 30) {
                totalPrice = totalPrice - (totalPrice * 0.15);
            }

        } else if ("Business".equals(groupType)) {
            switch (dayOfWeek) {
                case "Friday":
                    totalPrice = groupCount * 10.90;
                    if (groupCount >= 100) {
                        totalPrice = totalPrice - (10 * 10.90);
                    }
                    break;
                case "Saturday":
                    totalPrice = groupCount * 15.60;
                    if (groupCount >= 100) {
                        totalPrice = totalPrice - (10 * 15.60);
                    }
                    break;
                case "Sunday":
                    totalPrice = groupCount * 16;
                    if (groupCount >= 100) {
                        totalPrice = totalPrice - (10 * 16);
                    }
                    break;
            }


        } else if ("Regular".equals(groupType)) {
            switch (dayOfWeek) {
                case "Friday":
                    totalPrice = groupCount * 15;
                    break;
                case "Saturday":
                    totalPrice = groupCount * 20;
                    break;
                case "Sunday":
                    totalPrice = groupCount * 22.50;
                    break;
            }

            if (groupCount >= 10 && groupCount <= 20) {
                totalPrice = totalPrice - (totalPrice * 0.05);
            }
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
