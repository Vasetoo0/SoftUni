package simpleCalculations;

import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tables = Integer.parseInt(scanner.nextLine());
        double lengh = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        double coverArea = tables * (lengh + 2*0.30) * (width + 2*0.30);
        double boxArea = tables * (lengh/2)*(lengh/2);

        double usdPrice = coverArea * 7 +boxArea * 9;
        double bgnPrice = usdPrice * 1.85;

        System.out.printf("%.2f USD %n", usdPrice);
        System.out.printf("%.2f BGN", bgnPrice);

    }
}
