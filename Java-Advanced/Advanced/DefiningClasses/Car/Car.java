package Advanced.DefiningClasses.Car;

class Car {
    private String make;
    private String model;
    private int horsePower;

    private String getMake() {
        return make;
    }

    void setMake(String make) {
        this.make = make;
    }

    private String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    private int getHorsePower() {
        return horsePower;
    }

    void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    String getInfo() {

        return String.format("The car is: %s %s - %d HP.",
                this.getMake(),
                this.getModel(),
                this.getHorsePower());
    }
}
