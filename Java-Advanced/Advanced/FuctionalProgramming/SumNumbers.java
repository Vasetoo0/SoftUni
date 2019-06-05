package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String,Integer> parse = Integer::parseInt;

        String[] elements = scanner.nextLine().split(", ");

        System.out.println("Count = " + elements.length);

        int sum = 0;

        for (String element : elements) {
            sum += parse.apply(element);
        }

        System.out.println("Sum = " + sum);
    }

}
