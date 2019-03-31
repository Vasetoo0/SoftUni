package simpleCalculations;

import java.util.Scanner;

public class RadiansToDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rad = Double.parseDouble(scanner.nextLine());
        //double degree = rad/(Math.PI/180)+0.5 ;
        double degree = rad * 57.29578 ;

        System.out.println(Math.round(degree));

    }
}
