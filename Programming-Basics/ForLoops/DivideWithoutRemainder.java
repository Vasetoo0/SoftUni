package forLoops;

import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double couterFor2 = 0;
        double couterFor3 = 0;
        double couterFor4 = 0;


        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;


        for (int i = 1; i <= n; i++) {
            double num = Integer.parseInt(scanner.nextLine());

            if (num % 2 == 0) {
                couterFor2++;
            }
            if (num % 3 == 0) {
                couterFor3++;
            }
            if (num % 4 == 0) {
                couterFor4++;
            }
        }

        p1 = ( couterFor2/ n) * 100;
        p2 = ( couterFor3/ n) * 100;
        p3 = ( couterFor4/ n) * 100;


        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n",p1, p2, p3);


    }
}
