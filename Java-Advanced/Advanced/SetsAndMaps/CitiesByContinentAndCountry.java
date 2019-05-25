package Advanced.SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String,Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        continents.forEach((continent, country) -> {
            System.out.println(continent + ":");
            country.forEach((countr,cities) -> {
                System.out.println(String.format("%s -> %s", countr, String.join(", ", cities)));
            } );
        });
    }

}
