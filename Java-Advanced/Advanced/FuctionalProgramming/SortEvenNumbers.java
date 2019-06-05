package Advanced.FuctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split(", ");

        List<String> numbers = Arrays.stream(elements)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());


       String evenNums = String.join(", ",numbers);
        System.out.println(evenNums);

        List<String> nums = numbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", nums));


    }

}
