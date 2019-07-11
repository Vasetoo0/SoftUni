package OOP.Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split(" ");

        try {
            Pizza pizza = new Pizza(pizzaData[1],Integer.parseInt(pizzaData[2]));

            String[] doughData = scanner.nextLine().split(" ");
            try {
                Dough dough = new Dough(doughData[1],doughData[2],Double.parseDouble(doughData[3]));
                pizza.setDough(dough);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            String input;

            while (!"END".equals(input = scanner.nextLine())) {
                String[] toppingData = input.split(" ");

                try {
                    Topping topping = new Topping(toppingData[1],Double.parseDouble(toppingData[2]));
                    pizza.addTopping(topping);

                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
            }
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
}

}
