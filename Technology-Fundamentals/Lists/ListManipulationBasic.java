package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!"end".equals(inputLine)) {

            String[] tokens = inputLine.split(" ");


            switch (tokens[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);

                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);

                        numbers.removeIf(n -> n == numberToRemove);
//                    for (int i = 0; i < numbers.size(); i++) {
//
//                        if (numbers.get(i) == numberToRemove) {
//
//                            numbers.remove(numbers.get(i));
//                        }
//
//                    }
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(tokens[1]);

                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int indexAt = Integer.parseInt(tokens[2]);

                    numbers.add(indexAt, numberToInsert);
                    break;
            }

            inputLine = scanner.nextLine();
        }



        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

}
