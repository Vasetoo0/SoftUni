package TextAndRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input;

        Map<String, Integer> racers = new LinkedHashMap<>();

        Pattern lettersPattern = Pattern.compile("[A-Za-z]+");
        Pattern digitsPattern = Pattern.compile("[0-9]");

        while (!"end of race".equals(input = scanner.nextLine())) {

            String name = "";

            int distance = 0;

            Matcher matchLetter = lettersPattern.matcher(input);
            Matcher matchDigit = digitsPattern.matcher(input);


            while (matchLetter.find()) {
                name += matchLetter.group();
            }
            while (matchDigit.find()) {

                distance += Integer.parseInt(matchDigit.group());
            }

            if(names.contains(name)) {
                if(racers.containsKey(name)) {
                    racers.put(name, racers.get(name) + distance);
                }else {
                    racers.put(name, distance);
                }
            }
        }

        List<String> winners = new ArrayList<>();

        racers.entrySet().stream()
                .sorted((d1,d2) -> Integer.compare(d2.getValue(),d1.getValue()))
                .limit(3)
                .forEach(e -> winners.add(e.getKey()));

        System.out.println(String.format("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s\n", winners.get(0), winners.get(1), winners.get(2)));
    }

}
