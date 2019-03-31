package conditionalStatements;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.nextLine();

        double area = 0;
        if (shape.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());
            area = side * side;

        }else if (shape.equals("rectangle")) {
            double firstSide = Double.parseDouble(scanner.nextLine());
            double secondSide = Double.parseDouble(scanner.nextLine());
            area = firstSide * secondSide;

        }else if (shape.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * radius * radius;

        }else {
            double side = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            area = (side * height) / 2;
        }

        System.out.printf("%.3f%n", area);

    }
}
