package Advanced.IteratorsAndComparators.Exercise.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake lake = new Lake();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            List<Integer> lakeData = Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lake = new Lake(lakeData);
        }

        System.out.println();


        int counter = 0;
        for (Integer leaf : lake) {

            counter++;
            if (counter == lake.getLake().size()) {
                System.out.print(leaf);
            } else {
                System.out.print(leaf + ", ");

            }

        }
    }
}
