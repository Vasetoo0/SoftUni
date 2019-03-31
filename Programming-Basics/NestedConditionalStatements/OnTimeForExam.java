package nestedConditionalStatements;

import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourOfExam = Integer.parseInt(scanner.nextLine());
        int minOfExam = Integer.parseInt(scanner.nextLine());
        int hourArive = Integer.parseInt(scanner.nextLine());
        int minArive = Integer.parseInt(scanner.nextLine());

        int examHourToMin = (hourOfExam * 60) + minOfExam;
        int ariveHourToMin = (hourArive * 60) + minArive;
        int diff = examHourToMin - ariveHourToMin;

        if (diff < 0) {
            System.out.println("Late");
            if (Math.abs(diff) < 60) {
                System.out.printf("%d minutes after the start", Math.abs(diff));
            } else {
                int hoursLate = Math.abs(diff) / 60;
                int minLate = Math.abs(diff) % 60;
                if (minLate < 10) {
                    System.out.printf("%d:0%d hours after the start", hoursLate, minLate);
                } else {
                    System.out.printf("%d:%d hours after the start", hoursLate, minLate);
                }
            }
        } else if (diff > 0) {
            if (diff <= 30) {
                System.out.println("On Time");
                System.out.printf("%d minutes before the start", diff);
            } else if (diff < 60) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", diff);
            } else {
                int hoursEarly = diff / 60;
                int minEarly = diff % 60;
                if (minEarly < 10) {
                    System.out.println("Early");
                    System.out.printf("%d:0%d hours before the start", hoursEarly, minEarly);
                } else {
                    System.out.println("Early");
                    System.out.printf("%d:%d hours before the start", hoursEarly, minEarly);
                }
            }
        } else {
            System.out.println("On Time");
        }
    }
}
