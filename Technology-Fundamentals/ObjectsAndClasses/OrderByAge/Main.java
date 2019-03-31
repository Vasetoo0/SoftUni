package ObjectsAndClasses.OrderByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        List<Person> people = new ArrayList<>();

        while (!"End".equals(input = reader.readLine())) {

            String[] personDetails = input.split("\\s+");

            Person person = new Person(
                    personDetails[0],
                    personDetails[1],
                   Integer.parseInt(personDetails[2])
            );

            people.add(person);
        }

        people.stream()
                .sorted((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(System.out::println);


    }
}
