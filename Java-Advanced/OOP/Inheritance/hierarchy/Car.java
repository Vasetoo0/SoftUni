package OOP.Inheritance.hierarchy;

public class Car extends Vehicle {

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(3);
    }
}
