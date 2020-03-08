package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n < 0);

        if(numbers.size() < 1) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);

            System.out.println(numbers.toString().replaceAll("[\\[,\\]]", ""));
        }

    }
}
