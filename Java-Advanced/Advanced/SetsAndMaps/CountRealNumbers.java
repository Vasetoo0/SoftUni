package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> nums = new LinkedHashMap<>();

        String[] elements = scanner.nextLine().split(" ");

        for (int i = 0; i < elements.length; i++) {

            double number = Double.parseDouble(elements[i]);

            if(!nums.containsKey(number)) {
                nums.put(number, 1);
            } else {
                nums.put(number, nums.get(number) + 1);
            }

        }

        nums.forEach((k,v) -> {
            System.out.println(String.format("%.1f -> %d",k,v ));
        });


    }

}
