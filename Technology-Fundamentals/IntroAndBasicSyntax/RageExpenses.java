package IntroAndBasicSyntax;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetTrashCounter = 0;
        int mouseTrashCounter = 0;
        int keyboardTrashCounter = 0;
        int displayTrashCounter = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headsetTrashCounter++;
            }
            if (i % 3 == 0) {
                mouseTrashCounter++;
            }
            if (i % 6 == 0) {
                keyboardTrashCounter++;
            }

            displayTrashCounter = keyboardTrashCounter / 2;

        }

        double expenses = (headsetTrashCounter * headsetPrice) + (mouseTrashCounter * mousePrice) + (keyboardTrashCounter * keyboardPrice) +
                (displayTrashCounter * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
