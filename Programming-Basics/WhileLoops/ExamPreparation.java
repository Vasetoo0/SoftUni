package whileLoops;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int notAcceptedCount = Integer.parseInt(scanner.nextLine());


        int notAcceptedGrade = 0;
        int taskCount = 0;
        int gradesSum = 0;
        String nameOfLast = "";


        while (notAcceptedGrade < notAcceptedCount) {
            String nameOfTask = scanner.nextLine();

            if ("Enough".equals(nameOfTask)) {
                double averageGrade =(double)gradesSum / (double)taskCount;
                System.out.printf("Average score: %.2f%n", averageGrade);
                System.out.printf("Number of problems: %d%n", taskCount);
                System.out.printf("Last problem: %s", nameOfLast);
                break;
            }

            int grade = Integer.parseInt(scanner.nextLine());

            nameOfLast = nameOfTask;


            gradesSum += grade;

            taskCount++;

            if (grade <= 4) {
                notAcceptedGrade++;
            }

        }

        if (notAcceptedCount == notAcceptedGrade) {
            System.out.printf("You need a break, %d poor grades.", notAcceptedCount);
        }
    }
}
