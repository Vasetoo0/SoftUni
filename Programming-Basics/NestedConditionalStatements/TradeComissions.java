package nestedConditionalStatements;

import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double comission = 0;

        if (sales >= 0 && sales <= 500) {
            if ("Sofia".equals(town)) {
                comission = sales * 0.05;
            } else if ("Varna".equals(town)) {
                comission = sales * 0.045;
            } else if ("Plovdiv".equals(town)) {
                comission = sales * 0.055;
            }
        } else if (sales > 500 && sales <= 1000) {
            if ("Sofia".equals(town)) {
                comission = sales * 0.07;
            } else if ("Varna".equals(town)) {
                comission = sales * 0.075;
            } else if ("Plovdiv".equals(town)) {
                comission = sales * 0.08;
            }
        } else if (sales > 1000 && sales <= 10000) {
            if ("Sofia".equals(town)) {
                comission = sales * 0.08;
            } else if ("Varna".equals(town)) {
                comission = sales * 0.10;
            } else if ("Plovdiv".equals(town)) {
                comission = sales * 0.12;
            }
        } else {
            if ("Sofia".equals(town)) {
                comission = sales * 0.12;
            } else if ("Varna".equals(town)) {
                comission = sales * 0.13;
            } else if ("Plovdiv".equals(town)) {
                comission = sales * 0.145;
            }
        }
        if (sales < 0 || comission == 0) {
            System.out.println("error");
        }else {
            System.out.printf("%.2f", comission);
        }

    }
}
