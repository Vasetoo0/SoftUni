package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String operation = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        double result = mathOperations(firstNum,operation,secondNum);

        System.out.println(new DecimalFormat("#.##").format(result));

    }

    static double mathOperations(double first, String operation, double second){

        double operationsResult = 0.0;

        switch (operation) {
            case "+":
                operationsResult = first + second;
                break;
            case "-":
                operationsResult = first - second;
                break;
            case "/":
                operationsResult = first / second;
                break;
            case "*":
                operationsResult = first * second;
        }

        return operationsResult;
    }
}
