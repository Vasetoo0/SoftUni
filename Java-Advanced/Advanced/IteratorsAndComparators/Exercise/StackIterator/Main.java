package Advanced.IteratorsAndComparators.Exercise.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StackIterator stackIterator = new StackIterator();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+|, ");

            switch (data[0]) {
                case "Push":
                    int[] nums = Arrays.stream(data).skip(1).mapToInt(Integer::parseInt).toArray();

                    for (int num : nums) {
                        stackIterator.push(num);
                    }
                    break;
                case "Pop":
                    try {

                        stackIterator.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                    }
                    break;
            }
        }

        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
    }

}
