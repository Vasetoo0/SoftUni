package MapsLamdbaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> charCount = new LinkedHashMap<>();

        for (String word : input) {

            String[] chars = word.split("");

            for (String symbol : chars) {

                if(charCount.containsKey(symbol)) {

                    charCount.put(symbol, charCount.get(symbol) + 1);
                } else {

                    charCount.put(symbol, 1);
                }
            }
        }

        charCount.entrySet().forEach(e -> {
            System.out.println(
                    String.format("%s -> %d", e.getKey(), e.getValue())
            );
        });
    }
}
