package MapsLamdbaStreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .forEach(n -> System.out.print(n + " "));


    }

}
