package ObjectsAndClasses.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String input;

        while (!"end".equalsIgnoreCase(input = scanner.nextLine())) {

            String[] vehicleDetails = input.split(" ");

            Vehicle vehicle = new Vehicle(vehicleDetails[0], vehicleDetails[1]
            , vehicleDetails[2],Integer.parseInt(vehicleDetails[3]));

            vehicles.add(vehicle);
        }

        while (!"Close the Catalogue".equalsIgnoreCase(input = scanner.nextLine())) {

            for (Vehicle vehicle : vehicles) {

                if(input.equalsIgnoreCase(vehicle.getVehicleModel())) {
                    if(vehicle.getVehicleType().equalsIgnoreCase("car")) {
                        System.out.printf("Type: Car%nModel: %s%nColor: %s%nHorsepower: %d%n", vehicle.getVehicleModel()
                        , vehicle.getVehiclecolor(), vehicle.getHorsepower());
                    } else {
                        System.out.printf("Type: Truck%nModel: %s%nColor: %s%nHorsepower: %d%n", vehicle.getVehicleModel()
                                , vehicle.getVehiclecolor(), vehicle.getHorsepower());
                    }
                }

            }
        }

        double carHorsePowSum = 0;
        double truckHorsePowSum = 0;
        int carCounter = 0;
        int truckCounter = 0;

        for (Vehicle vehicle : vehicles) {

            if("car".equalsIgnoreCase(vehicle.getVehicleType())) {
                carHorsePowSum += vehicle.getHorsepower();
                carCounter++;
            } else {
                truckHorsePowSum += vehicle.getHorsepower();
                truckCounter++;
            }
        }

        double averageCarHorsePow = carHorsePowSum / carCounter;
        double averageTruckHorsePow = truckHorsePowSum / truckCounter;

        for (Vehicle vehicle : vehicles) {
            if(vehicle.getVehicleType().equalsIgnoreCase("car")) {
                System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHorsePow);
                break;
            }
        }
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getVehicleType().equalsIgnoreCase("truck")) {
                System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckHorsePow);
                break;
            }
        }

    }
}
