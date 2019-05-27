package Advanced.SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> chars = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if(!chars.containsKey(symbol)) {
                chars.put(symbol, 1);
            } else {
                chars.put(symbol,chars.get(symbol) + 1);
            }


        }
        chars.forEach((key,value) -> {
            System.out.println(String.format("%s: %d time/s", key, value));
        });
    }

}
