package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;

        while (!"end".equals(input = scanner.nextLine())) {

            for (int i = 0; i < numbers.length; i++) {
                Function<Integer, Integer> changeNumber = change(input, numbers[i]);

                numbers[i] = changeNumber.apply(numbers[i]);
            }
            if (input.equals("print")) {
                for (int number : numbers) {
                    System.out.print(number + " ");

                }
                System.out.println();
            }
        }
    }

    private static Function<Integer, Integer> change(String input, int number) {

        switch (input) {
            case "add":
                return x -> number + 1;
            case "multiply":
                return x -> number * 2;
            case "subtract":
                return x -> number - 1;
        }
        return x -> number;
    }

}
