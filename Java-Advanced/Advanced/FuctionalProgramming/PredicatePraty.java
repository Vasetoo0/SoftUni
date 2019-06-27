package Advanced.FuctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePraty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;

        while (!"Party!".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            String command = data[0];
            String type = data[1];
            String criteria = data[2];
            Predicate<String> predicate = createPredicate(type, criteria);

            if (command.equals("Remove")) {
                names.removeIf(predicate);
            } else {

                ArrayList<String > namesToAdd = new ArrayList<>();

                names.forEach(name -> {
                    if(predicate.test(name)) {
                        namesToAdd.add(name);
                    }
                });
                names.addAll(namesToAdd);
            }
        }

        Collections.sort(names);
        if (names.size() == 0 || names.contains("")) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(String.join(", ", names));
            System.out.print(" are going to the party!");
        }

    }

    private static Predicate<String> createPredicate(String type, String criteria) {
        Predicate<String> predicate;
        if (type.equals("StartsWith")) {
            predicate = name -> name.startsWith(criteria);

        } else {
            if (type.equals("EndsWith")) {
                predicate = name -> name.endsWith(criteria);

            } else {
                predicate = name -> name.length() == Integer.parseInt(criteria);

            }
        }
        return predicate;
    }


}
