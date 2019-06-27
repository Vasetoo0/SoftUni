package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        int[] numbers = IntStream.rangeClosed(1, range).toArray();

        List<Integer> numsToDivide = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = num -> {

            boolean allAreDivisible = true;

            for (int numToDivide : numsToDivide) {
                if(num % numToDivide != 0) {
                    allAreDivisible = false;
                    break;
                }
            }
            return allAreDivisible;
        };

        Arrays.stream(numbers)
                .filter(isDivisible::test)
                .forEach(num -> System.out.print(num + " "));
    }

}
