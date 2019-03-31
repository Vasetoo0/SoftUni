package nestedLoops;

import java.util.Scanner;

public class CodingSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String numString = Integer.toString(num);

        int lastNum = num;

        for (int i = 0; i < numString.length(); i++) {
            int number = lastNum % 10;
            int lastDigit = (lastNum - number) / 10;
            lastNum = lastDigit;

            if (number == 0) {
                System.out.println("ZERO");
            } else {
                for (int g = 1; g <= number; g++) {
                    int symbol = number + 33;
                    System.out.printf("%s",(char)symbol);
                }
                System.out.println();
            }
        }

    }
}
