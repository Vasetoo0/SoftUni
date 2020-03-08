package IntroAndBasicSyntax;

import java.util.Scanner;

public class gamingScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyHave = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();

        double balance = moneyHave;

        double totalSpent = 0;

        while (!"Game Time".equals(game)) {

            if ("OutFall 4".equals(game)) {
                if (balance >= 39.99) {
                    balance -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought OutFall 4");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else if ("CS: OG".equals(game)) {
                if (balance >= 15.99) {
                    balance -= 15.99;
                    totalSpent += 15.99;
                    System.out.println("Bought CS: OG");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else if ("Zplinter Zell".equals(game)) {
                if (balance >= 19.99) {
                    balance -= 19.99;
                    totalSpent += 19.99;
                    System.out.println("Bought Zplinter Zell");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else if ("Honored 2".equals(game)) {
                if (balance >= 59.99) {
                    balance -= 59.99;
                    totalSpent += 59.99;
                    System.out.println("Bought Honored 2");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else if ("RoverWatch".equals(game)) {
                if (balance >= 29.99) {
                    balance -= 29.99;
                    totalSpent += 29.99;
                    System.out.println("Bought RoverWatch");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else if ("RoverWatch Origins Edition".equals(game)) {
                if (balance >= 39.99) {
                    balance -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought RoverWatch Origins Edition");

                } else {
                    System.out.println("Too Expensive");
                    //game = scanner.nextLine();
                }
            } else {
                System.out.println("Not Found");
            }
            if (balance <= 0) {
                System.out.println("Out of money!");
                return;
            }
            game = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, moneyHave - totalSpent);
    }
}
