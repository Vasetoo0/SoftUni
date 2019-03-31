package nestedConditionalStatements;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String priceType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double wholeSumChairs = rows * columns;

        double price = 0;

        if ("Premiere".equals(priceType)){
            price = wholeSumChairs * 12.00;
        }else if ("Normal".equals(priceType)){
            price = wholeSumChairs * 7.50;
        }else {
            price = wholeSumChairs * 5.00;
        }

        System.out.printf("%.2f leva", price);

    }
}
