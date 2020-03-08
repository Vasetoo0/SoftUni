package OOP.Polymorphism.Farm.animals;

public class Tiger extends Felime {

    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }
}
