package Advanced.SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args ) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String student = data[0];
            double grade = Double.parseDouble(data[1]);

            if(!students.containsKey(student)) {
                students.put(student, new ArrayList<>());
                students.get(student).add(grade);
            } else {
                students.get(student).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> kvp : students.entrySet()) {
            System.out.print(kvp.getKey() +  " -> ");
            double avrSum = 0;
            for (Double grade : kvp.getValue()) {
                System.out.print(String.format("%.2f ", grade));

                avrSum += grade;
            }
            System.out.println(String.format("(avg: %.2f)", avrSum / kvp.getValue().size()));
        }
    }

}
