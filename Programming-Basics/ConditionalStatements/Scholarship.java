package conditionalStatements;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double average = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        double socialPrice = minSalary * 0.35;
        double excellentPrice = average * 25;

        if (income < minSalary && average > 4.5 && average >= 5.5) {
            if (socialPrice > excellentPrice) {
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialPrice));
            }else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentPrice));
            }
        } else if (income < minSalary && average > 4.5) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialPrice));
        } else if (average >= 5.5) {
//            if (excellentPrice > socialPrice) {
//                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentPrice));
//            } else {
//                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialPrice));
//            }
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentPrice));
        } else {
            System.out.println("You cannot get a scholarship!");
        }



    }
}