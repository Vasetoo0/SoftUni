package TextAndRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(.\\d+)?($|(?=\\s))");
        Matcher number = pattern.matcher(input);

        List<String> numbers = new ArrayList<>();

        while (number.find()) {

            numbers.add(number.group());
        }

        System.out.println(String.join(" ", numbers));
    }

}
