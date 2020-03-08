package nestedConditionalStatements;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        int celebrationCount = Integer.parseInt(scanner.nextLine());
        int weekendInHome = Integer.parseInt(scanner.nextLine());

        double gamesInSofia = (48 - weekendInHome) * 0.75;
        double gamesInCelebrationDays = celebrationCount * 0.6666666666666667;

        double weekendAndCelebrationGames = gamesInSofia + weekendInHome + gamesInCelebrationDays;

        double plusGames = 0;

        if ("leap".equals(year)) {
            plusGames = 0.15 * weekendAndCelebrationGames;
        }else {
            plusGames = 0;
        }

        double allGames = weekendAndCelebrationGames + plusGames;

        System.out.printf("%.0f", Math.floor(allGames));


    }
}
