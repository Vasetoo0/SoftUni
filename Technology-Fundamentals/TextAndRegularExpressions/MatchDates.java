package TextAndRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(?<days>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b");
        Matcher dates = pattern.matcher(input);

        while (dates.find()) {

            String day = dates.group("days");
            String month = dates.group("month");
            String year = dates.group("year");

            System.out.println(String.format("Day: %s, Month: %s, Year: %s", day, month, year));
        }
    }

}
