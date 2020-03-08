package OOP.Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        String output;
        double fuelNeeded = distance * this.getFuelConsumption();
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;

            DecimalFormat format = new DecimalFormat("#.##");

            output = String.format("%s travelled %s km", this.getClass().getSimpleName(),
                    format.format(distance));

        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        return output;
    }

    public void refuel(double fuelQuantity) {
        if(fuelQuantity + this.fuelQuantity  > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }else if(fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
