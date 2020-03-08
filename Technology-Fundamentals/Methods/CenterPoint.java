package Methods;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X1 = Integer.parseInt(scanner.nextLine());
        int Y1 = Integer.parseInt(scanner.nextLine());
        int X2 = Integer.parseInt(scanner.nextLine());
        int Y2 = Integer.parseInt(scanner.nextLine());

        System.out.println("(" + closerToCenter(X1, Y1, X2, Y2) + ")");


    }

    static String closerToCenter(int x1, int y1, int x2, int y2) {

        String closest = "";

        int firstPoint = Math.abs(x1) + Math.abs(y1);
        int secondPoint = Math.abs(x2) + Math.abs(y2);

        if (firstPoint < secondPoint) {
            closest += x1 + ", " + y1;
        } else if (firstPoint > secondPoint) {
            closest += x2 + ", " + y2;
        } else {
            closest += x1 + ", " + y1;
        }

        return closest;
    }

}
