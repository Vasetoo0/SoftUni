package simpleCalculations;

import java.util.Scanner;

public class Alcohol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceWhiskey = Double.parseDouble(scanner.nextLine());
        double beer = Double.parseDouble(scanner.nextLine());
        double wine = Double.parseDouble(scanner.nextLine());
        double rakia = Double.parseDouble(scanner.nextLine());
        double whiskey = Double.parseDouble(scanner.nextLine());

        double priceOfrakia = priceWhiskey / 2;
        double priceOfbeer = priceOfrakia - (priceOfrakia * 0.8);
        double priceOfwine = priceOfrakia - (priceOfrakia * 0.4);

        double beerMoney = beer * priceOfbeer;
        double wineMoney = wine * priceOfwine;
        double rakiaMoney = rakia * priceOfrakia;
        double whiskeyMoney = whiskey * priceWhiskey;

        double sum =  beerMoney + wineMoney +rakiaMoney + whiskeyMoney;

        System.out.printf("%.2f", sum);

    }
}

