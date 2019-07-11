package OOP.InterfaceAndAbstraction.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String drName = scanner.nextLine();

        Ferrari ferrari = new Ferrari(drName);

        System.out.println(ferrari.toString());

    }

}
