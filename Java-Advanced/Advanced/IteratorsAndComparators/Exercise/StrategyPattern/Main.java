package Advanced.IteratorsAndComparators.Exercise.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Set<Person> personsSetOne = new TreeSet<>(new NameComparator());
        Set<Person> personsSetTwo = new TreeSet<>(new AgeComparator());


        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);

            personsSetOne.add(person);
            personsSetTwo.add(person);
        }

        for (Person person : personsSetOne) {
            System.out.println(person.toString());
        }
        for (Person person : personsSetTwo) {
            System.out.println(person.toString());
        }


    }

}
