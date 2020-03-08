package simpleCalculations;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double p1 = Math.abs(x1-x2);
        double p2 = Math.abs(y1-y2);

        System.out.println(p1*p2);
        System.out.println(2*(p1+p2));

    }
}
