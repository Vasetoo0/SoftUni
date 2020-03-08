package ObjectsAndClasses.StudentsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] studentDetails = scanner.nextLine().split("\\s+");

            Student student = new Student(studentDetails[0], studentDetails[1]
                    , Double.parseDouble(studentDetails[2]));

            students.add(student);
        }

        students.stream()
                .sorted((s1,s2)-> Double.compare(s2.getGrade(), s1.getGrade()))
                .forEach(System.out::println);
    }

}
