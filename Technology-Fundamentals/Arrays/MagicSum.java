package Arrays;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);

        }
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            for (int j   = i+1; j < numbers.length; j++) {
                int numbersSum = 0;
                numbersSum = numbers[i] + numbers[j];
                if (numbersSum == number) {
                    System.out.print(numbers[i] + " ");
                    System.out.print(numbers[j] + " ");
                    System.out.println();
                }
            }
        }
    }
}
