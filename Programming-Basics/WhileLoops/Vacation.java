package whileLoops;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int spendDays = 0;
        int days = 0;
        double moneyLeft = availableMoney;


        while (spendDays < 5) {
            String action = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            days++;


            if ("spend".equals(action)) {
                moneyLeft -= money;
                spendDays++;

                if (moneyLeft <= 0) {
                    moneyLeft = 0;
                }
            } else if ("save".equals(action)) {
                spendDays = 0;
                moneyLeft += money;
                if (moneyLeft >= vacationPrice) {
                    System.out.printf("You saved the money for %d days.", days);
                    break;
                }
            }
        }

        if (spendDays >= 5) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }

    }
}
