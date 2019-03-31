package conditionalStatements;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double unit = Double.parseDouble(scanner.nextLine());
        String from = scanner.nextLine();
        String to = scanner.nextLine();

        if (from.equals("mm")) {
            unit = unit / 1000;
        }else if (from.equals("cm")) {
            unit = unit / 100;
        }else if (from.equals("mi")) {
            unit = unit / 0.000621371192;
        }else if (from.equals("in")) {
            unit = unit / 39.3700787;
        }else if (from.equals("km")) {
            unit = unit / 0.001;
        }else if (from.equals("ft")) {
            unit = unit / 3.2808399;
        }else if (from.equals("yd")) {
            unit = unit / 1.0936133;
        }

        if (to.equals("mm")) {
            unit = unit * 1000;
        }else if (to.equals("cm")) {
            unit = unit * 100;
        }else if (to.equals("mi")) {
            unit = unit * 0.000621371192;
        }else if (to.equals("in")) {
            unit = unit * 39.3700787;
        }else if (to.equals("km")) {
            unit = unit * 0.001;
        }else if (to.equals("ft")) {
            unit = unit * 3.2808399;
        }else if (to.equals("yd")) {
            unit = unit * 1.0936133;
        }

        System.out.printf("%.8f", unit);

    }
}
