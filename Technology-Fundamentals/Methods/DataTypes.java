package Methods;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int num = Integer.parseInt(scanner.nextLine());
                System.out.println(dataTypeFinder(num));
                break;
            case "real":
                double real = Double.parseDouble(scanner.nextLine());
                System.out.printf("%.2f", dataTypeFinder(real));
                break;
            case "string":
                String text = scanner.nextLine();
                System.out.println(dataTypeFinder(text));
                break;

        }

    }

    static int dataTypeFinder(int num){

        return num * 2;

    }

    static double dataTypeFinder(double real){

       return real * 1.5;

    }

    static String dataTypeFinder(String text){

        return "$" + text + "$";
    }
}
