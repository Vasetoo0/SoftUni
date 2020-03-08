package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Double>> shops = new TreeMap<>();

        String input;

        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] data = input.split(", ");

            String shopName = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(product,price);
        }

        for (Map.Entry<String, Map<String, Double>> kvp : shops.entrySet()) {
            System.out.println(String.format("%s->", kvp.getKey()));
            kvp.getValue().forEach((product, price) -> {
                System.out.println(String.format("Product: %s, Price: %.1f", product, price));
            });
        }
    }

}
