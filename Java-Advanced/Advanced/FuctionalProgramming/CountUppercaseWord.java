package Advanced.FuctionalProgramming;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] text = scanner.nextLine().split(" ");

        Predicate<String> isUperrCase = word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> upperWords = new ArrayList<>();

        for (String word : text) {
            if(isUperrCase.test(word)) {
                upperWords.add(word);
            }
        }
        System.out.println(upperWords.size());

        upperWords
                .forEach(System.out::println);
    }

}
