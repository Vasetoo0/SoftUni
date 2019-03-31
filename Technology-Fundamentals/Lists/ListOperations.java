package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equalsIgnoreCase(input)) {

            String[] command = input.split(" +");

            if ("Add".equalsIgnoreCase(command[0])){

                int numberToAdd = Integer.parseInt(command[1]);

                numbers.add(numberToAdd);
            } else if ("Insert".equalsIgnoreCase(command[0])) {

                int numberToInsert = Integer.parseInt(command[1]);
                int indexToInsert = Integer.parseInt(command[2]);



                if (indexToInsert <= numbers.size() && indexToInsert >= 0) {

                    numbers.add(indexToInsert, numberToInsert);

                } else {
                    System.out.println("Invalid index");
                }

            } else if ("Remove".equalsIgnoreCase(command[0])) {

                int indexToRemove = Integer.parseInt(command[1]);

                if (indexToRemove < numbers.size() && indexToRemove >= 0) {

                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if ("Shift".equalsIgnoreCase(command[0])) {

                int count = Integer.parseInt(command[2]);

                if (numbers.size() > 0) {

                    if ("left".equalsIgnoreCase(command[1])) {

                        for (int i = 0; i < count; i++) {
                            numbers.add(numbers.size(), numbers.get(0));
                            numbers.remove(numbers.get(0));
                        }
                    } else if ("right".equalsIgnoreCase(command[1])) {
                        for (int i = 0; i < count; i++) {
                            numbers.add(0, numbers.get(numbers.size()-1));
                            numbers.remove(numbers.size()-1);
                        }
                    }

                } else {
                    System.out.println("Invalid index");
                }


            }

            input = scanner.nextLine();

        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]", ""));

    }
}
