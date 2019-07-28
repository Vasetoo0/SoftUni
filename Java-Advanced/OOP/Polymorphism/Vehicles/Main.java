package OOP.Polymorphism.Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = null;
        Vehicle truck = null;
        Vehicle bus = null;
        try {

            car = produceVehicle(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {

            truck = produceVehicle(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {

            bus = produceVehicle(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

//        Vehicle truck = produceVehicle(scanner.nextLine().split("\\s+"));
//
//        Vehicle bus = produceVehicle(scanner.nextLine().split("\\s+"));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int commandCount = Integer.parseInt(scanner.nextLine());

        while (commandCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String output;
            if (tokens[0].equals("Drive")) {
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
                System.out.println(output);
            } else if (tokens[0].equals("DriveEmpty")) {
                if (bus instanceof Bus) {
                    ((Bus) bus).reduceConsumption();
                }
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
                System.out.println(output);
            } else {
                try {
                    vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }


        }

        vehicles.forEach((k, v) -> System.out.println(v.toString()));
    }

    private static Vehicle produceVehicle(String[] data) {
        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Truck")) {
            vehicle = new Truck(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Bus")) {
            vehicle = new Bus(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        }

        return vehicle;
    }
}
