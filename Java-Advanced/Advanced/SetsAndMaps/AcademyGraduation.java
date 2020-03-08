package Advanced.SetsAndMaps;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");

            double avgSum = 0;
            for (int j = 0; j < grades.length; j++) {
                avgSum += Double.parseDouble(grades[j]);

            }
            double avgGrade = avgSum / grades.length;

            students.putIfAbsent(name, avgGrade);
            students.put(name, avgGrade);

        }

        students.forEach((s,g) -> {
            System.out.println(String.format("%s is graduated with %s",s,g));
        });
    }

}
