package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class ThePartyReservationFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        HashMap<String, Predicate<String>> filters = new HashMap<>();

        String input;
        while (!"Print".equals(input = scanner.nextLine())) {

            String[] commands = input.split(";");

            String type = commands[1];
            String criteria = commands[2];

            String filterName = type + criteria;

            if (commands[0].contains("Add")) {
                Predicate<String> predicate;

                if (type.contains("Starts")) {
                    predicate = name -> name.startsWith(criteria);
                } else if (type.contains("Ends")) {
                    predicate = name -> name.endsWith(criteria);
                } else if (type.contains("Length")) {
                    predicate = name -> name.length() == Integer.parseInt(criteria);
                } else {
                    predicate = name -> name.contains(criteria);
                }
                filters.putIfAbsent(filterName, predicate);
            } else {

                filters.remove(filterName);
            }
        }

        Arrays.stream(names).forEach(name -> {
            boolean[] haveToBeRemoved = new boolean[1];

            filters.forEach((k, v) -> {
                if (v.test(name)) {
                    haveToBeRemoved[0] = true;
                }

            });
            if (!haveToBeRemoved[0]) {
                System.out.print(name + " ");
            }
        });
    }
}
