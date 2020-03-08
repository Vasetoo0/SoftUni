package Advanced.FuctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] peopleData = reader.readLine().split(", ");

            people.put(peopleData[0], Integer.parseInt(peopleData[1]));

        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = test(condition, ageLimit);

        Consumer<Map.Entry<String,Integer>> printer = print(format);

        printPeople(people,tester,printer);
    }

    private static void printPeople(Map<String, Integer> people,
                                    Predicate<Integer> tester,
                                    Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if(tester.test(person.getValue())) {
                printer.accept(person);
            }
        }
    }

    private static Predicate<Integer> test(String condition, int ageLimit) {

        if ("younger".equals(condition)) {
            return x -> x <= ageLimit;
        }
        return x -> x >= ageLimit;
    }

    private static Consumer<Map.Entry<String, Integer>> print(String format) {

        switch (format) {
            case "name age":

                return person -> System.out.println(String.format("%s - %s", person.getKey(), person.getValue()));
            case "age":
                return person -> System.out.println(String.format("%s",person.getValue()));
        }
        return person -> System.out.println(String.format("%s",person.getKey()));
    }

}
