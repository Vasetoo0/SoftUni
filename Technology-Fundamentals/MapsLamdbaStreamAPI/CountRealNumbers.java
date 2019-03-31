package MapsLamdbaStreamAPI;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numsMap = new TreeMap<>();

        for (double num : nums) {

            if(!numsMap.containsKey(num)) {

                numsMap.put(num, 0);

            }

            numsMap.put(num, numsMap.get(num) + 1);

        }

        String pattern = "%.0f -> %d";

        for (Map.Entry<Double, Integer> kvp : numsMap.entrySet()) {
            System.out.println(String.format(pattern, kvp.getKey(), kvp.getValue()));
        }

    }
}
