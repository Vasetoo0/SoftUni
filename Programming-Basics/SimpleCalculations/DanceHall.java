package simpleCalculations;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lengh = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double A = Double.parseDouble(scanner.nextLine());

        double hallArea = (lengh * 100) * (width * 100);
        A = A*100;
        double wardArea = (A*A);
        double benchArea = hallArea/10;
        double freeSpace = hallArea - wardArea - benchArea;

        double people = freeSpace / (40 + 7000);

        System.out.println((int)Math.floor(people));


    }
}
