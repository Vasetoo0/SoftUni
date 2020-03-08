package conditionalStatements;

import java.util.Scanner;

public class ToYShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzleNum = Integer.parseInt(scanner.nextLine());
        int talkingDollsNum = Integer.parseInt(scanner.nextLine());
        int tedybearsNum = Integer.parseInt(scanner.nextLine());
        int minionsNum = Integer.parseInt(scanner.nextLine());
        int truckNum = Integer.parseInt(scanner.nextLine());

        double wholeSum = (puzzleNum * 2.6) + (talkingDollsNum * 3) + (tedybearsNum * 4.1) + (minionsNum * 8.2) +
                (truckNum * 2);
        int toysNum = puzzleNum + talkingDollsNum + tedybearsNum + minionsNum + truckNum;

        double discount = 0.0;

        if (toysNum >= 50) {
            discount = wholeSum * 0.25;
        }
        double endSum = wholeSum - discount;
        //double rent = endSum * 0.10;
        double profit = endSum - (endSum * 0.10);

        if (vacationPrice <= profit) {
            double moneyLeft = profit - vacationPrice;
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        }else {
            double moneyNeeded = vacationPrice - profit;
            System.out.printf("Not enough money! %.2f lv needed.", moneyNeeded);
        }
    }
}
