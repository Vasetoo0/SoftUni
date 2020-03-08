package MapsLamdbaStreamAPI;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);

        }

        String pattern = "%s - %s";

        for (Map.Entry<String, List<String>> kvp : words.entrySet()) {

            System.out.println(String.format(pattern, kvp.getKey(), String.join(", ", kvp.getValue())));

        }
    }
}
