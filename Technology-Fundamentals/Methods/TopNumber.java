package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            if (istopNumber(String.valueOf(i))) {
                System.out.println(i);
            }
        }
    }

    static boolean istopNumber(String num){
        String[] numArr = num.split("");

        int[] number = new int[numArr.length];

        for (int i = 0; i < numArr.length; i++) {

            number[i] = Integer.parseInt(numArr[i]);

            }

        int digitsSum = 0;

        for (int i = 0; i < number.length; i++) {

            digitsSum += number[i];

        }
        if (digitsSum % 8 == 0) {

            for (int j = 0; j < numArr.length; j++) {

                if (number[j] % 2 != 0) {
                    return true;

                }
            }
        }
        return false;
    }
}
