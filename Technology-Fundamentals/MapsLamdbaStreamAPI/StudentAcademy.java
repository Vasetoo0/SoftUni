package MapsLamdbaStreamAPI;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }

        Map<String, Double> studentsAverage = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> kvp : students.entrySet()) {

            double averageGrade = kvp.getValue().stream()
                    .mapToDouble(d -> d).average().getAsDouble();

            if (averageGrade >= 4.50) {

                studentsAverage.put(kvp.getKey(), averageGrade);
            }
        }

        studentsAverage.entrySet().stream()
                .sorted((g1,g2) -> Double.compare(g2.getValue(),g1.getValue()))
                .forEach(s -> System.out.println(String.format("%s -> %.2f",s.getKey(),s.getValue())));
    }
}
