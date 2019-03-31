package whileLoops;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int steps = 0;

        int allSteps = 0;


        while (!"Going home".equals(input)) {
            steps = Integer.parseInt(input);

            allSteps += steps;

            if (allSteps >= 10000) {
                System.out.println("Goal reached! Good job!");
                break;
            }

            input = scanner.nextLine();

        }



        if ("Going home".equals(input)) {
            input = scanner.nextLine();
            steps = Integer.parseInt(input);
            allSteps += steps;
            if (allSteps >= 10000) {
                System.out.println("Goal reached! Good job!");
            } else {
                System.out.printf("%d more steps to reach goal.", 10000 - allSteps);

            }


        }


    }
}
