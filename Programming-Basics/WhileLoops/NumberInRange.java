package whileLoops;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        while (num <= 0 || num > 100) {
            System.out.println("Invalid number!");
            System.out.print("Еnter a number in the range [1...100]:");
            num = Integer.parseInt(scanner.nextLine());
        }

        System.out.printf("The number is: %d", num);

    }
}
