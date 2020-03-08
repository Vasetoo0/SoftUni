package DataTypesAndVariables;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxVolume = 0.0;
        String biggestKeg = "";

        for (int i = 1; i <= n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

//            if (n == 1) {
//                biggestKeg = model;
//            }

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume >= maxVolume) {
                maxVolume = volume;
                biggestKeg = model;
            }
        }

        System.out.println(biggestKeg);

    }
}
