package whileLoops;

import java.util.Scanner;

public class WaterDispenser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int glassVolume = Integer.parseInt(scanner.nextLine());

        int fullGlass = 0;
        int buttonTaped = 0;

        while (fullGlass < glassVolume) {
            String button = scanner.nextLine();

            if ("Easy".equals(button)) {
                fullGlass += 50;
                buttonTaped++;
            } else if ("Medium".equals(button)) {
                fullGlass += 100;
                buttonTaped++;
            } else {
                fullGlass += 200;
                buttonTaped++;
            }
        }

        if (fullGlass > glassVolume) {
            System.out.printf("%dml has been spilled.", fullGlass - glassVolume);
        } else {
            System.out.printf("The dispenser has been tapped %d times.",buttonTaped);
        }

    }
}
