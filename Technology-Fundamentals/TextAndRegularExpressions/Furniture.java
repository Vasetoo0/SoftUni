package TextAndRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<name>[A-Za-z\\s]+)<<(?<price>\\d+(.\\d+)?)!(?<quantity>\\d+)");
        String data;
        List<String> itemsBought = new ArrayList<>();

        double totalSum = 0;

        while (!"Purchase".equals(data = scanner.nextLine())) {

            Matcher validPurchase = pattern.matcher(data);

            while (validPurchase.find()) {


                totalSum += Double.parseDouble(validPurchase.group("price")) *
                            Integer.parseInt(validPurchase.group("quantity"));

                itemsBought.add(validPurchase.group("name"));
            }
        }

            System.out.println("Bought furniture:");
            for (String item : itemsBought) {
                System.out.printf("%s%n",item);
            }

        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
