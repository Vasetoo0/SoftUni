package OOP.Encapsulation.PizzaCalories;

public class Validator {

    static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    static void validateDoughType(String flourType) {
        if (!flourType.equalsIgnoreCase("White")
                && !flourType.equalsIgnoreCase("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    static void validateDoughTechnique(String flourTechnique) {
        if (!flourTechnique.equalsIgnoreCase("Crispy")
                && !flourTechnique.equalsIgnoreCase("Chewy")
                && !flourTechnique.equalsIgnoreCase("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    static void validateToppingType(String toppingType) {
        if(!toppingType.equalsIgnoreCase("Meat") &&
                !toppingType.equalsIgnoreCase("Veggies") &&
                !toppingType.equalsIgnoreCase("Cheese") &&
                !toppingType.equalsIgnoreCase("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    static void validateToppingsNumber(int number) {
        if(number < 0 || number > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    static void validateToppingWeight(double weight,String toppingType) {
        if(weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType));
        }
    }
}
