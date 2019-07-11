package OOP.InterfaceAndAbstraction.CarShop;

public class Seat extends CarImpl implements Sellable{

    private Double price;


    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have 4 tires%n" +
                "%s sells for %.6f",
                this.getModel(),this.countryProduced(),
                this.getModel(),this.getPrice());
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
