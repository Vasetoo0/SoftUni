package Advanced.DefiningClasses.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");

            String model = data[0];

            Engine engine = new Engine(Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]));
            Cargo cargo = new Cargo(Integer.parseInt(data[3]), data[4]);
            Tires tires = new Tires(Double.parseDouble(data[5]),
                    Double.parseDouble(data[5]),
                    Double.parseDouble(data[5]),
                    Double.parseDouble(data[5]));

            Car car = new Car(engine,cargo,tires);

            cars.put(model,car);
        }

        String command = reader.readLine();

        if("fragile".equals(command)) {
            cars.entrySet().stream()
                    .filter(c -> c.getValue().getCargo().getCargoType().equals("fragile") &&
                            c.getValue().getTires().getAverage() < 1)
                    .forEach(c -> System.out.println(c.getKey()));
        } else {
            cars.entrySet().stream()
                    .filter(c -> c.getValue().getCargo().getCargoType().equals("flamable") &&
                            c.getValue().getEngine().getPower() > 250)
                    .forEach(c -> System.out.println(c.getKey()));
        }
    }

}
