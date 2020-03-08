package Advanced.IteratorsAndComparators.Exercise.Collection;

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

        Collection collection = new Collection(data);

        String input;

        while (!"END".equals(input = reader.readLine())) {

            switch (input) {
                case "Move":
                    System.out.println(collection.move());
                    break;
                case "HasNext":
                    System.out.println(collection.hasNext());
                    break;
                case "Print":
                    try {
                        collection.print();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "PrintAll":
                    try{
                       collection.printAll();
                    } catch (Exception e) {
                        System.out.println("Invalid Operation!");
                    }
            }
        }
    }

}
