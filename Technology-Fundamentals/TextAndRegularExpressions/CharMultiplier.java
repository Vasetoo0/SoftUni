package TextAndRegularExpressions;

import java.util.Scanner;

public class CharMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");


            int sum = multiplyStrings(input[0],input[1]);
        System.out.println(sum);

    }

    private static int multiplyStrings(String firstString, String secondString) {

        int sum = 0;

        if(firstString.length() > secondString.length()) {
            for (int i = 0; i < secondString.length(); i++) {
                sum += firstString.charAt(i) * secondString.charAt(i);
            }
            for (int i = secondString.length(); i < firstString.length(); i++) {
                sum += firstString.charAt(i);
            }
        } else if (secondString.length() > firstString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                sum += secondString.charAt(i) * firstString.charAt(i);
            }
            for (int i = firstString.length(); i < secondString.length(); i++) {
                sum += secondString.charAt(i);
            }
        } else {
            for (int i = 0; i < firstString.length(); i++) {
                sum += firstString.charAt(i) * secondString.charAt(i);
            }
        }


        return sum;
    }

}
