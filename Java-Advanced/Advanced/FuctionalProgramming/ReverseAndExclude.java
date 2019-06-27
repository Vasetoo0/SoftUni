package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiPredicate<Integer,Integer> numsToRemove = (num, num1) -> num % num1 != 0;

        List<Integer> numbers = (List<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int numToCheck = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        numbers.stream()
                .filter(e -> numsToRemove.test(e,numToCheck))
                .forEach(n -> System.out.print(n + " "));


    }

}
