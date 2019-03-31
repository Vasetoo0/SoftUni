package simpleCalculations;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double days = Double.parseDouble(scanner.nextLine());
        double cookers = Double.parseDouble(scanner.nextLine());
        double cakes = Double.parseDouble(scanner.nextLine());
        double waffles = Double.parseDouble(scanner.nextLine());
        double pancakes = Double.parseDouble(scanner.nextLine());

        cakes = cakes * 45;
        waffles = waffles * 5.80;
        pancakes = pancakes * 3.20;

        double sumOneDay = (cakes + waffles + pancakes) * cookers;
        double sumAllDays = sumOneDay * days;
        double sumAfter = sumAllDays - (sumAllDays * 0.125);

        System.out.printf("%.2f", sumAfter);

    }
}
