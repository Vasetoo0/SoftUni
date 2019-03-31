package MapsLamdbaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Double> productsQuantity = new LinkedHashMap<>();

        while (!"buy".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            String productName = data[0];
            double price = Double.parseDouble(data[1]);
            double quantity = Double.parseDouble(data[2]);

            if(!productsPrice.containsKey(productName)) {

                productsPrice.put(productName,price);
                productsQuantity.put(productName,quantity);

            } else {

                if(productsPrice.get(productName) != price){
                    productsPrice.put(productName,price);
                }

                productsQuantity.put(productName, productsQuantity.get(productName) + quantity);
            }
        }

        for (Map.Entry<String, Double> kvp : productsPrice.entrySet()) {
            for (Map.Entry<String, Double> kvp1 : productsQuantity.entrySet()) {
                if(kvp.getKey().equals(kvp1.getKey())) {
                    System.out.println(String.format("%s -> %.2f", kvp.getKey(), kvp.getValue() * kvp1.getValue()));
                }
            }
        }
    }
}
