package whileLoops;

import java.util.Scanner;

public class Graduation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int years = 1;

        double sum = 0;
        double notPass = 0;

        while(years <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 4.00) {
                sum += grade;

                years++;
            } else  {
                notPass += 1;
            }
            if (notPass == 2) {
                System.out.printf("%s has been excluded at %d grade",name, years);
                break;
            }

        }

        double averageGrade = sum / 12;

        if (years > 12 && averageGrade >= 4.00) {
            System.out.printf("%s graduated. Average grade: %.2f", name, averageGrade);
        }



    }
}