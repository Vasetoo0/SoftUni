package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> namesChecker = name -> name.length() <= length;
        Consumer<String> printer = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(namesChecker)
                .forEach(printer);
    }

}
