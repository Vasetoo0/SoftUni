package ObjectsAndClasses.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Students> students = new ArrayList<>();

        String input = "";

        while (!"end".equalsIgnoreCase(input = scanner.nextLine())) {

            String[] studentInfo = input.split("\\s+");

            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int years =Integer.parseInt(studentInfo[2]);
            String homeTown = studentInfo[3];

            Students student = new Students(firstName,lastName,years,homeTown);

            students.add(student);
        }

        String filterCity = scanner.nextLine();

        for (Students student : students) {
            if(filterCity.equalsIgnoreCase(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName()
                        , student.getLastName()
                        , student.getYears());
            }

        }


    }
}
