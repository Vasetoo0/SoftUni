package OOP.Polymorphism.Vehicles;

public class Truck extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double fuelQuantity) {
        super.refuel(fuelQuantity * 0.95);
    }
}
