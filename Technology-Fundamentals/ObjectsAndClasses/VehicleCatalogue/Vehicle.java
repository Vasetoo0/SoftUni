package ObjectsAndClasses.VehicleCatalogue;

public class Vehicle {
    private String  vehicleType;
    private String  vehicleModel;
    private String  vehiclecolor;
    private Integer  horsepower;

    public Vehicle(String vehicleType, String vehicleModel, String vehiclecolor, Integer horsepower) {
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehiclecolor = vehiclecolor;
        this.horsepower = horsepower;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public Integer getHorsepower() {
        return horsepower;
    }
}
