package Advanced.DefiningClasses.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int carsCount = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        while (carsCount-- != 0) {
            String[] data = reader.readLine().split("\\s+");
            Car car = new Car();

            String make = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);

            car.setMake(make);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);

        }

        cars.forEach(c -> System.out.println(c.getInfo()));

    }
}
