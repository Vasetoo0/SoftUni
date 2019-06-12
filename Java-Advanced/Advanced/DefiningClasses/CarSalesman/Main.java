package Advanced.DefiningClasses.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int enginesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < enginesCount; i++) {

            String[] engineData = reader.readLine().split("\\s+");

            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            Engine engine = new Engine(model, power);

            if(engineData.length == 3) {
                if(Character.isDigit(engineData[2].charAt(0))) {
                    engine.setDisplacement(engineData[2]);
                } else {
                    engine.setEfficiency(engineData[2]);
                }
            } else if(engineData.length == 4) {
                engine.setDisplacement(engineData[2]);
                engine.setEfficiency(engineData[3]);
            }

            engines.add(engine);
        }

        int carsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < carsCount; i++) {

            String[] carsData = reader.readLine().split("\\s+");

            String carModel = carsData[0];
            String engineModel = carsData[1];

            Car car = new Car(carModel);

            engines.forEach(e -> {
                if(e.getModel().equals(engineModel)) {

                    car.setEngine(e);
                }
            });

            if(carsData.length == 3) {
                if(Character.isDigit(carsData[2].charAt(0))) {
                    car.setWeight(carsData[2]);
                } else {
                    car.setColor(carsData[2]);
                }
            } else if (carsData.length == 4) {
                car.setWeight(carsData[2]);
                car.setColor(carsData[3]);
            }
            cars.add(car);
        }
        cars.forEach(c -> {
            System.out.println(c.toString());
        });

    }

}
