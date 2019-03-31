package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());



        System.out.println(new DecimalFormat("#.####").format(area(width,length)));



    }

    static double area(double width, double length){
        return width * length;
    }
}
