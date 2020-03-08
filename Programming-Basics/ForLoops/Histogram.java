package forLoops;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double numsUnder200 = 0;
        double numsBetween200And399 = 0;
        double numsBetween400And599 = 0;
        double numsBetween600And799 = 0;
        double numsGreaterThan800 = 0;

        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;
        double p4 = 0.0;
        double p5 = 0.0;

        for (int i = 1; i <= n; i++) {
            double num = Integer.parseInt(scanner.nextLine());

            if (num < 200) {
                numsUnder200++;
            } else if (num >= 200 && num <= 399) {
                numsBetween200And399++;
            } else if (num >= 400 && num <= 599) {
                numsBetween400And599++;
            } else if (num >= 600 && num <= 799) {
                numsBetween600And799++;
            } else {
                numsGreaterThan800++;
            }
        }

        p1 = (numsUnder200 / n) * 100;
        p2 = (numsBetween200And399 / n) * 100;
        p3 = (numsBetween400And599 / n) * 100;
        p4 = (numsBetween600And799 / n) * 100;
        p5 = (numsGreaterThan800 / n) * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n",p1, p2, p3, p4, p5);

    }
}
