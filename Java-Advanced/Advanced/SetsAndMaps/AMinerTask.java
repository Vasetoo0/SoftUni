package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourses = new LinkedHashMap<>();

        String input;

        while (!"stop".equals(input = scanner.nextLine())) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if(resourses.containsKey(input)) {
                resourses.put(input,resourses.get(input) + quantity);
            } else {
                resourses.put(input,quantity);
            }
        }

        resourses.forEach((r,q) -> {
            System.out.println(String.format("%s -> %s",r,q));
        });
    }

}
