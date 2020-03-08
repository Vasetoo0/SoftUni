package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("[A-Za-z0-9]+@[A-Za-z0-9]+\\.bg");

        String input;

        while (!"stop".equals(input = scanner.nextLine())) {
            String email = scanner.nextLine();

            Matcher matcher = pattern.matcher(email);

            if(matcher.find()) {

                    emails.put(input, email);

            }
        }

        emails.forEach((key,value) -> {
            System.out.println(String.format("%s -> %s", key, value));
        });
    }

}
