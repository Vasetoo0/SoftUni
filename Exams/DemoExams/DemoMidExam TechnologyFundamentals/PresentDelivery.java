package DemoTest;

import java.util.Arrays;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("[@]"))
                .mapToInt(Integer::parseInt).toArray();

        String input = "";

        int santaIndex = 0;

        while (!"Merry Xmas!".equals(input = scanner.nextLine())){

            String[] data = input.split("\\s+");

            int jumpLenght = Integer.parseInt(data[1]);

            for (int i = 0; i < jumpLenght; i++) {
                santaIndex++;
                if (santaIndex > houses.length - 1) {
                    santaIndex = 0;
                }
            }

            if (houses[santaIndex] == 0) {
                System.out.printf("House %d will have a Merry Christmas.%n", santaIndex );
            } else {
                houses[santaIndex] -= 2;
            }
        }

        System.out.printf("Santa's last position was %d.%n", santaIndex);

        int failedHouses = 0;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != 0) {
                failedHouses++;
            }
        }

        if (failedHouses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %d houses.", failedHouses);
        }
    }
}
