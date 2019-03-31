package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Long> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Long::parseLong).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equalsIgnoreCase(input)) {

            String[] command = input.split("\\s+");

            if ("Delete".equalsIgnoreCase(command[0])) {

                long nummberToDelete = Long.parseLong(command[1]);

                numbers.removeIf(n ->  n == nummberToDelete);

            } else if ("Insert".equalsIgnoreCase(command[0])) {

                long numberToInsert = Long.parseLong(command[1]);
                int indexToInsert = Integer.parseInt(command[2]);

                if(indexToInsert < numbers.size() && indexToInsert >= 0) {

                    numbers.add(indexToInsert, numberToInsert);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[,\\]]",""));

    }
}
