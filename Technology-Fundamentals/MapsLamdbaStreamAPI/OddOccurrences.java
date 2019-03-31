package MapsLamdbaStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (String word : words) {

            String wordToLowerCase = word.toLowerCase();

            if (wordsCount.containsKey(wordToLowerCase)) {
                wordsCount.put(wordToLowerCase, wordsCount.get(wordToLowerCase) + 1);
            } else {
                wordsCount.put(wordToLowerCase, 1);
            }
        }
        ArrayList<String> odd = new ArrayList<>();
        for (Map.Entry<String, Integer> kvp : wordsCount.entrySet()) {

            if(kvp.getValue() % 2 == 1) {
                odd.add(kvp.getKey());
            }
        }

        System.out.println(String.join(", ", odd));
    }
}
