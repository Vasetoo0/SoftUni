package simpleCalculations;

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        System.out.printf("Area = %f%n", Math.PI*r*r);
        System.out.printf("Perimeter = %f", 2*Math.PI*r);

    }
}
