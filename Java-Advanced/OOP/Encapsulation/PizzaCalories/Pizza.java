package OOP.Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);

    }

    private void setToppings(int numberOfToppings) {
        Validator.validateToppingsNumber(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        if(this.toppings.size() < 10) {

            this.toppings.add(topping);
        }

    }

    public String getName() {
        return this.name;
    }

    public double getOverallCalories(){
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();

    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

}
