package conditionalStatements;

import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stepsCount = Integer.parseInt(scanner.nextLine());
        int dancersCount = Integer.parseInt(scanner.nextLine());
        int daysLearning = Integer.parseInt(scanner.nextLine());

        double stepsDay = stepsCount / daysLearning;
        double stepsPerDay = Math.ceil((stepsDay / stepsCount) * 100);
        double percentPerDancer = stepsPerDay / dancersCount;

        if (stepsPerDay < 13) {
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.", percentPerDancer);
        }else if (stepsPerDay > 13) {
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.", percentPerDancer);
        }


    }
}
