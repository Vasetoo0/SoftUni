package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int wagonCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {

            String[] command = input.split(" ");

            boolean isAddCommand = command.length > 1;

            if (isAddCommand) {

                passengers.add(Integer.parseInt(command[1]));

            } else {

                for (int i = 0; i < passengers.size(); i++) {

                    int newPassengers = 0;

                    newPassengers = passengers.get(i) + Integer.parseInt(command[0]);

                    if (newPassengers <= wagonCapacity) {

                        passengers.set(i, newPassengers);

                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(passengers.toString().replaceAll("[\\[,\\]]", ""));

    }
}
