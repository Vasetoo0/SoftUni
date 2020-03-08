package forLoops;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int openTabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < openTabs; i++) {
            String siteName = scanner.nextLine();

            if ("Facebook".equals(siteName)) {
                salary = salary - 150;
            } else if ("Instagram".equals(siteName)) {
                salary = salary - 100;
            } else if ("Reddit".equals(siteName)) {
                salary = salary - 50;
            }

            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }
        if (salary > 0) {
            System.out.printf("%d", salary);
        }


    }
}
