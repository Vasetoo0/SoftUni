package Advanced.DefiningClasses.Constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int carsCount = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        while (carsCount-- != 0) {
            String[] data = reader.readLine().split("\\s+");

            if(data.length == 1) {
                Car car = new Car(data[0]);
                cars.add(car);
            } else {
                Car car = new Car(data[0], data[1], Integer.parseInt(data[2]));
                cars.add(car);
            }
        }

        cars.forEach(c -> System.out.println(c.getInfo()));

    }

}
