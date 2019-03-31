package nestedConditionalStatements;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quatity = Double.parseDouble(scanner.nextLine());

        double price = 0.0;
        //banana / apple / orange / grapefruit / kiwi / pineapple / grapes
        //цена	2.70	1.25	0.90	1.60	3.00	5.60	4.20

        if ("Monday".equals(dayOfWeek) ||
                "Tuesday".equals(dayOfWeek) ||
                "Wednesday".equals(dayOfWeek) ||
                "Thursday".equals(dayOfWeek) ||
                "Friday".equals(dayOfWeek)) {
            if ("banana".equals(fruit)) {
                price = 2.50;
            } else if ("apple".equals(fruit)) {
                price = 1.20;
            } else if ("orange".equals(fruit)) {
                price = 0.85;
            } else if ("grapefruit".equals(fruit)) {
                price = 1.45;
            } else if ("kiwi".equals(fruit)) {
                price = 2.70;
            } else if ("pineapple".equals(fruit)) {
                price = 5.50;
            } else if ("grapes".equals(fruit)) {
                price = 3.85;
            }
        } else if ("Saturday".equals(dayOfWeek) ||
                "Sunday".equals(dayOfWeek)) {
            if ("banana".equals(fruit)) {
                price = 2.70;
            } else if ("apple".equals(fruit)) {
                price = 1.25;
            } else if ("orange".equals(fruit)) {
                price = 0.90;
            } else if ("grapefruit".equals(fruit)) {
                price = 1.60;
            } else if ("kiwi".equals(fruit)) {
                price = 3.00;
            } else if ("pineapple".equals(fruit)) {
                price = 5.60;
            } else if ("grapes".equals(fruit)) {
                price = 4.20;
            }
        } else {
            System.out.println("error");
        }

         if (price == 0) {
             System.out.println("error");
         }else {
             System.out.println(quatity * price);
         }


    }
}
