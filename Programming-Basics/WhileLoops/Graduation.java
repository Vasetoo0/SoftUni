package whileLoops;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        double years = 1;

        double sum = 0;

        while(years <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 4.00) {
                sum += grade;

                years++;
            }


        }

        double averageGrade = sum / 12;

        if (averageGrade >= 4.00) {
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }



    }
}
