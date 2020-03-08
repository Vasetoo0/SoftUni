package TextAndRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%(?:[^\\$%.]*)" +
                "<(?<product>[^<>]+)>(?:[^\\$%.]*)\\|" +
                "(?<count>\\d+)\\|(?:[^\\$%.]*?)" +
                "(?<price>[-+]?\\d+\\.?\\d+)\\$");

        String data;

        double totalIncome = 0;

        while (!"end of shift".equals(data = scanner.nextLine())) {

            double personPrice = 0;

            Matcher matcher = pattern.matcher(data);

            if(matcher.find()) {

                personPrice = Double.parseDouble(matcher.group("price")) *
                        Integer.parseInt(matcher.group("count"));

                totalIncome += personPrice;

                System.out.println(String.format("%s: %s - %.2f", matcher.group("name"),
                        matcher.group("product"),
                        personPrice));
            }
        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
