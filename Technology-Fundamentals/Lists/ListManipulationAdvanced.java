package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!"end".equals(inputLine)) {

            String[] tokens = inputLine.split(" ");


            switch (tokens[0]) {
                case "Contains":

                    int numberToCheck = Integer.parseInt(tokens[1]);

                    if (numbers.contains(numberToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

                    break;
                case "Print":
                    if (tokens[1].equalsIgnoreCase("even")) {

                        for (Integer number : numbers) {

                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                        break;
                    }

                case "Print odd":

                    if (tokens[1].equalsIgnoreCase("odd")) {

                        for (Integer number : numbers) {

                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();

                        break;
                    }

                case "Get":

                    int sum = 0;

                    for (Integer number : numbers) {

                        sum += number;
                    }

                    System.out.println(sum);

                    break;
                case "Filter":

                    String condition = tokens[1];
                    int numberToCompare = Integer.parseInt(tokens[2]);

                    switch (condition) {
                        case "<":
                            for (Integer number : numbers) {

                                if (number < numberToCompare) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();

                            break;
                        case ">":
                            for (Integer number : numbers) {

                                if (number > numberToCompare) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();

                            break;
                        case "<=":
                            for (Integer number : numbers) {

                                if (number <= numberToCompare) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();

                            break;
                        case ">=":
                            for (Integer number : numbers) {

                                if (number >= numberToCompare) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();

                            break;
                    }
            }

            inputLine = scanner.nextLine();
        }

    }
}
