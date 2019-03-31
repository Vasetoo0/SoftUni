package Arrays;

import java.util.Scanner;

public class DaysOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayOfWeek = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        if (dayOfWeek < 1 || dayOfWeek > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(daysOfWeek[dayOfWeek - 1]);
        }


    }
}
