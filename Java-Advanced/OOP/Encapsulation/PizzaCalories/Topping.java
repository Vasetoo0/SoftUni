package OOP.Encapsulation.PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(weight, this.toppingType);
        this.weight = weight;

    }

    private void setToppingType(String toppingType) {
        Validator.validateToppingType(toppingType);
        this.toppingType = toppingType;
    }

    public String getToppingType() {
        return this.toppingType;
    }

    public double getWeight() {
        return this.weight;
    }

    double calculateCalories() {
        return (this.getWeight() * 2) * getModifier(this.getToppingType());

    }

    private double getModifier(String toppingType) {
        double modifier = 0;
        switch (toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return modifier;
    }


}
