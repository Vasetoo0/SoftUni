package forLoops;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int years = Integer.parseInt(scanner.nextLine());
        double washingmashinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toysCount = 0;
        double lvCount = 0.0;
        double savedMoney = 0.0;
        double brotherTook = 0.0;

        for (int i = 1; i <= years; i++) {
            if (i % 2 == 0) {
                lvCount += 10;
                savedMoney += lvCount;
                brotherTook++;
            } else {
                toysCount += 1;
            }
        }

        int toysPrice = toyPrice * toysCount;

        double finalMoney = toysPrice + savedMoney - brotherTook;

        double diff = Math.abs(washingmashinePrice - finalMoney);

        if (finalMoney >= washingmashinePrice) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }


    }
}
