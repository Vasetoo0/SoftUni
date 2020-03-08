package MapsLamdbaStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {

            String[] data = input.split(" -> ");

            String companyName = data[0];
            String employeeID = data[1];

            if(!companies.containsKey(companyName)) {

                companies.put(companyName, new ArrayList<>());
                companies.get(companyName).add(employeeID);
            } else {

                if (!companies.get(companyName).contains(employeeID)) {
                    companies.get(companyName).add(employeeID);
                }
            }
        }
        companies.entrySet()
                .forEach(e -> {
                    System.out.println(String.format("%s", e.getKey()));
                    for (String student : e.getValue()) {
                        System.out.println(String.format("-- %s", student));
                    }
                });
    }
}
