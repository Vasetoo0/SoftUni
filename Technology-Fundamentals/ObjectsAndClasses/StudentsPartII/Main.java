package ObjectsAndClasses.StudentsPartII;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Student> students = new ArrayList<>();

        String input = "";

        while (!"end".equalsIgnoreCase(input = scanner.nextLine())) {

            String[] studentInfo = input.split("\\s+");

            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int years = Integer.parseInt(studentInfo[2]);
            String homeTown = studentInfo[3];

            if (isExisting(students, firstName, lastName)) {
                Student student = getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setYears(years);
                student.setHomeTown(homeTown);


            } else {
                Student student = new Student(firstName, lastName, years, homeTown);

                students.add(student);
            }

        }

        String filterCity = scanner.nextLine();

        for (Student student : students) {
            if (filterCity.equalsIgnoreCase(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName()
                        , student.getLastName()
                        , student.getYears());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {

            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isExisting(List<Student> students, String firstName, String lastName) {

        for (Student student : students) {

            if (student.getFirstName().equalsIgnoreCase(firstName) && student.getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }

}
