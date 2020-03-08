package Methods;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());
        double thirdNum = Double.parseDouble(scanner.nextLine());


        System.out.println(numberSign(firstNum, secondNum, thirdNum));


    }

    static String numberSign(double first, double second, double third) {

        String numberKind = "";

        if (first == 0 || second == 0 || third == 0) {
            numberKind += "zero";
        } else if (first < 0 && second < 0 && third < 0
                || first < 0 && second > 0 && third > 0
                || first > 0 && second < 0 && third > 0
                || first > 0 && second > 0 && third < 0) {
            numberKind += "negative";
        } else {
            numberKind += "positive";
        }

        return numberKind;
    }
}
