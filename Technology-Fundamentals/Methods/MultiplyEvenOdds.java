package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvenOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(multiplyEvenOddsDigits(number));



    }

    static int multiplyEvenOddsDigits(int number){

       int evenSum = 0;
       int oddSum = 0;

       while (number != 0) {

           int num = number % 10;

           if (num % 2 == 0) {
               evenSum += num;
           } else {
               oddSum += num;
           }

           number = number - (number % 10);
           number = number / 10;
       }

       return evenSum * oddSum;
    }
}
