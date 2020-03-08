package DataTypesAndVariables;

import java.util.Scanner;

public class RefactorVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.print("Length: " );
        System.out.print("Width: " );
        System.out.print("Height: " );
        double volume = (double) 1/3 * (length * width) * height;
        System.out.printf("Pyramid Volume: %.2f", volume);


    }
}
