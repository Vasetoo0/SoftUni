package DataTypesAndVariables;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int capacity = 255;
        int litresFiled = 0;

        for (int i = 0; i < n; i++) {
            int waterQuantity = Integer.parseInt(scanner.nextLine());

            if (capacity - waterQuantity < 0) {
                System.out.println("Insufficient capacity!");
            } else {
                capacity -= waterQuantity;
                litresFiled += waterQuantity;

            }

        }

        System.out.println(litresFiled);

    }
}
