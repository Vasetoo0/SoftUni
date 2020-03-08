package Advanced.FuctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOdd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split(" ");

        String command = scanner.nextLine();

        Predicate<Integer> isEvenOrOdd = x -> x % 2 == 0;

        if(command.equals("odd")) {
            isEvenOrOdd = x -> x % 2 != 0;
        }

        int[] numbers = IntStream.rangeClosed(Integer.parseInt(range[0]), Integer.parseInt(range[1])).toArray();

        Arrays.stream(numbers)
                .filter(isEvenOrOdd::test)
                .forEach(e -> System.out.print(e + " "));

    }

}
