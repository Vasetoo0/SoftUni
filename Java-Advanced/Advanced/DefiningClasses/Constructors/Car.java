package Advanced.DefiningClasses.Constructors;

class Car {
    private String make;
    private String model;
    private int horsePower;

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String make,String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

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
