package IntroAndBasicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataTypeFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        while (!input.equals("END")) {
            try {
                Long.parseLong(input);
                System.out.printf("%s is integer type%n", input);
                input = reader.readLine();
                continue;
            } catch (Exception ignored) {
            }
            try {
                Double.parseDouble(input);
                System.out.printf("%s is floating point type%n", input);
                input = reader.readLine();
                continue;
            } catch (Exception ignored) {
            }
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
            }else if (input.length() == 1 &&
                    (input.charAt(0) < 48 || input.charAt(0) > 57)) {
                System.out.printf("%s is character type%n", input);
            }else {
                System.out.printf("%s is string type%n", input);
            }
            input = reader.readLine();
        }

    }
}
