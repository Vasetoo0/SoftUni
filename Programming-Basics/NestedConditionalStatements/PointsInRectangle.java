package nestedConditionalStatements;

import java.util.Scanner;

public class PointsInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        boolean leftToRight = x >= x1;
        boolean rightToLeft = x <= x2;
        boolean bottomToTop = y >= y1;
        boolean topToBottom = y <= y2;

        if (leftToRight && rightToLeft && bottomToTop && topToBottom) {
            System.out.println("Inside");
        }else {
            System.out.println("Outside");
        }

    }
}
