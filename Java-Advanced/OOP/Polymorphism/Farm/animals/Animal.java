package OOP.Polymorphism.Farm.animals;


import OOP.Polymorphism.Farm.food.Food;

public abstract class Animal {
    private String type;
    private String name;
    private double weight;
    private int foodEaten;

    public Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public abstract String makeSound();

    public void eat(Food food) {


        if(this.type.equals("Tiger") &&
                food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(
                    this.type +
                    "s are not eating that type of food!");
        } else if(food.getClass().getSimpleName().equals("Meat") && (this.type.equals("Zebra") ||
               this.type.equals("Mouse"))) {
            String exceptionMessage =this.type + "s are not eating that type of food!";
            if(this.type.equals("Mouse")) {
                exceptionMessage = "Mice are not eating that type of food!";
            }
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.foodEaten += food.getQuantity();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
