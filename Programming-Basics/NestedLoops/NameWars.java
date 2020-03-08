package nestedLoops;

import java.util.Scanner;

public class NameWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int maxSum = 0;
        String maxName = "";

        while (!name.equals("STOP")) {

            int charSum = 0;
            for (int i = 0; i < name.length(); i++) {
                int symbol = name.charAt(i);
                charSum += symbol;
            }

            if (charSum > maxSum) {
                maxSum = charSum;
                maxName = name;
            }

            name = scanner.nextLine();

        }

        System.out.printf("Winner is %s - %d!", maxName, maxSum);

    }
}
