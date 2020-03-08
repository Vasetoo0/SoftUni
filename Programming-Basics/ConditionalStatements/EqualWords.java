package conditionalStatements;

import java.util.Scanner;

public class EqualWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        if (first.equalsIgnoreCase(second)) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
