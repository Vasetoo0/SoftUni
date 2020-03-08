package Methods;

import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (command){
            case "add":
                add(a, b);
                break;
            case "subtract":
                subtract(a,b);
                break;
            case "multiply":
                multiply(a,b);
                break;
            case "divide":
                divide(a,b);
                break;

        }

    }

    static void add(int a, int b){
        System.out.println(a + b);
    }

    static void subtract(int a, int b){
        System.out.println(a - b);
    }

    static void multiply(int a, int b){
        System.out.println(a * b);
    }

    static void divide(int a, int b){
        System.out.println(a / b);
    }
}
