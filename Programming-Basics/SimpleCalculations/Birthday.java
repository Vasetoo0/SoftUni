package simpleCalculations;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        percent = percent * 0.01;

        double volume = ((a*b*h)*0.001) * (1 - percent);

        System.out.printf("%.3f", volume);


    }
}
