package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesPopulation = new LinkedHashMap<>();

        String input;

        while (!"report".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(data[2]);

            if(!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(city, population);
            } else {
                countries.get(country).put(city, population);
            }
            if(!countriesPopulation.containsKey(country)) {
                countriesPopulation.put(country, population);
            } else {
                countriesPopulation.put(country,countriesPopulation.get(country) + population);
            }

        }

        countriesPopulation.entrySet().stream()
                .sorted((p1,p2) -> Long.compare(p2.getValue(),p1.getValue()))
                .forEach(e ->{
                    System.out.println(String.format("%s (total population: %s)", e.getKey(),e.getValue()));
                    countries.get(e.getKey()).entrySet().stream()
                            .sorted((p1,p2) -> Long.compare(p2.getValue(),p1.getValue()))
                            .forEach(c -> {
                                System.out.println(String.format("=>%s: %s", c.getKey(),c.getValue()));
                            });
                } );

    }

}
