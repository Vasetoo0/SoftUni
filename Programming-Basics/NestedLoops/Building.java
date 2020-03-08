package nestedLoops;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floorCount = Integer.parseInt(scanner.nextLine());
        int roomCount = Integer.parseInt(scanner.nextLine());

        for (int i = floorCount; i >= 1; i--) {
            for (int j = 0; j < roomCount; j++) {
                if (i == floorCount) {
                    System.out.print("L");
                } else if (i % 2 != 0) {
                    System.out.print("A");
                } else {
                    System.out.print("O");
                }

                System.out.print("" + i + j + " ");
            }


            System.out.println();

        }


    }
}
