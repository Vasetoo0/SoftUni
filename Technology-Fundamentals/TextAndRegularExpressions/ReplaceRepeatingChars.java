package TextAndRegularExpressions;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        StringBuilder newString = new StringBuilder();

        int length = text.length();

        String equal = "";
        int counter = 1;


        while (text.length() > 1){

                newString.append(text.charAt(0));

            for (int j = text.length()-1; j >= 0; j--) {
                if(text.length() > 1) {
                    if(text.charAt(0) == text.charAt(1) ) {
                        text = text.substring(1);
                    }else {
                        text = text.substring(1);
                        break;
                    }
                } else {
                    text = text.substring(1);
                    break;
                }
            }
            if (text.length() == 1) {
                newString.append(text.charAt(0));
            }

        }
        System.out.println(newString);
    }
}
