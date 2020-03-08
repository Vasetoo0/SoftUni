package OOP.Polymorphism.Farm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                format.format(this.getWeight()),
                this.livingRegion,
                this.getFoodEaten());
    }
}
