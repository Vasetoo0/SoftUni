package Advanced.IteratorsAndComparators.Exercise.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        String input;



        while (!"END".equals(input = reader.readLine())) {
            String[] personData = input.split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];

            Person person = new Person(name, age, town);

            persons.add(person);

        }

        int index =Integer.parseInt(reader.readLine());

        int equalCount = 1;
        int notEqualCount = 0;
        int totalCount = 0;

        for (int i = 0; i < index - 1; i++) {
            if(persons.get(index - 1).compareTo(persons.get(i)) == 0) {
                equalCount++;
            } else {
                notEqualCount++;
            }
        }

        for (int i = index; i < persons.size(); i++) {
            if(persons.get(index).compareTo(persons.get(i)) == 0) {
                equalCount++;
            } else {
                notEqualCount++;
            }
        }

        totalCount = persons.size();

        if(equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.print(equalCount + " ");
            System.out.print(notEqualCount + " ");
            System.out.print(totalCount);
        }



    }

}
