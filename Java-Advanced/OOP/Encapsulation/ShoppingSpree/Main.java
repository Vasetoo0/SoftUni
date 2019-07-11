package OOP.Encapsulation.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleInfo = scanner.nextLine().split(";");

        for (String info : peopleInfo) {
            String[] personInfo = info.split("=");

            try {
                Person person = new Person(personInfo[0], Double.parseDouble(personInfo[1]));
                persons.putIfAbsent(personInfo[0], person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String[] productsInfo = scanner.nextLine().split(";");

        for (String info : productsInfo) {
            String[] productInfo = info.split("=");
            try {
                Product product = new Product(productInfo[0], Double.parseDouble(productInfo[1]));
                products.putIfAbsent(productInfo[0], product);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }


        }

        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            String[] buyData = input.split(" ");



            try {
                persons.get(buyData[0]).buyProduct(products.get(buyData[1]));

                System.out.println(String.format("%s bought %s",buyData[0],buyData[1]));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        persons.forEach((key, value) -> System.out.println(value.toString()));


    }

}
