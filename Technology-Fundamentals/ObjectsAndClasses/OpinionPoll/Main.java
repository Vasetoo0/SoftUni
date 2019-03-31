package ObjectsAndClasses.OpinionPoll;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++){

            String[] personDetails = scanner.nextLine().split(" ");

            String personName = personDetails[0];
            int personAge = Integer.parseInt(personDetails[1]);

            Person person = new Person(personName, personAge);

            people.add(person);

        }

        people.stream()
                .filter(e -> e.getAge() > 30)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.printf("%s - %s%n", person.getName(), person.getAge()));

    }

}
