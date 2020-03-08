package conditionalStatements;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum1 = Integer.parseInt(scanner.nextLine());
        int sum2 = Integer.parseInt(scanner.nextLine());
        int sum3 = Integer.parseInt(scanner.nextLine());

        int total = sum1 + sum2 + sum3;
        int min = total / 60;
        int sec = total % 60;

        if (sec < 10) {
            System.out.println(min  + ":0" + sec);
        }else {
            System.out.println(min + ":" + sec);
        }





    }
}
