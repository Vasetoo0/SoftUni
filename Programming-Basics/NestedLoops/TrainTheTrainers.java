package nestedLoops;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juryCount = Integer.parseInt(scanner.nextLine());
        String presentationName = scanner.nextLine();


        double averageGradeSum = 0;
        int averageGradeCount = 0;
        double finalAverageGrade = 0;

        while (!"Finish".equals(presentationName)) {

            double gradeSum = 0;
            double averageGrade = 0;

            for (int i = 1; i <= juryCount; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum += grade;
            }

            averageGrade = gradeSum / juryCount;
            System.out.printf("%s - %.2f.", presentationName, averageGrade);
            System.out.println();
            averageGradeCount++;
            averageGradeSum += averageGrade;

            presentationName = scanner.nextLine();
        }
        finalAverageGrade = averageGradeSum / averageGradeCount;

        System.out.printf("Student's final assessment is %.2f.", finalAverageGrade);

    }
}
