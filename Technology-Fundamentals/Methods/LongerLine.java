package Methods;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X1 = Integer.parseInt(scanner.nextLine());
        int Y1 = Integer.parseInt(scanner.nextLine());
        int X2 = Integer.parseInt(scanner.nextLine());
        int Y2 = Integer.parseInt(scanner.nextLine());
        int X3 = Integer.parseInt(scanner.nextLine());
        int Y3 = Integer.parseInt(scanner.nextLine());
        int X4 = Integer.parseInt(scanner.nextLine());
        int Y4 = Integer.parseInt(scanner.nextLine());

        int firstLine = line(X1, Y1, X2, Y2);
        int secondLine = line(X3, Y3, X4, Y4);

        if (firstLine >= secondLine) {

            System.out.println(closerToCenter(X1, Y1, X2, Y2));

        } else {

            System.out.println(closerToCenter(X3, Y3, X4, Y4));
        }


    }

    static int line(int x, int y, int x1, int y1) {

        return Math.abs(x) + Math.abs(y) + Math.abs(x1) + Math.abs(y1);
    }

    static String closerToCenter(int x1, int y1, int x2, int y2) {

        String closest = "";

        int firstPoint = Math.abs(x1) + Math.abs(y1);
        int secondPoint = Math.abs(x2) + Math.abs(y2);

        if (firstPoint < secondPoint) {

            closest += "(" + x1 + ", " + y1 + ")" + "(" + x2 + ", " + y2 + ")";

        } else if (firstPoint > secondPoint)  {

            closest += "(" + x2 + ", " + y2 + ")" + "(" + x1 + ", " + y1 + ")";


        } else {

            closest += "(" + x1 + ", " + y1 + ")" + "(" + x2 + ", " + y2 + ")";
        }

            return closest;
        }
    }

