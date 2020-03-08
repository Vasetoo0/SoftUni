package nestedConditionalStatements;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        String outfit = "";
        String shoes = "";

        if (degrees >= 10 && degrees <= 18) {
            if ("Morning".equals(timeOfDay)) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (degrees >= 25) {
            if ("Morning".equals(timeOfDay)) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if ("Afternoon".equals(timeOfDay)) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            } else {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else {
            if ("Morning".equals(timeOfDay) || "Evening".equals(timeOfDay)) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        }

        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);

    }
}
