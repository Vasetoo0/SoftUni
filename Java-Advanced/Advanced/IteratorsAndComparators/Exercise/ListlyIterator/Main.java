package Advanced.IteratorsAndComparators.Exercise.ListlyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> data = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListlyIterator listlyIterator = new ListlyIterator(data);

        String input;

        while (!"END".equals(input = reader.readLine())) {

            switch (input) {
                case "Move":
                    System.out.println(listlyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listlyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listlyIterator.print();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }

                    break;
            }
        }
    }

}
