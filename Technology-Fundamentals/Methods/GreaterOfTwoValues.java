package Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        if ("int".equalsIgnoreCase(dataType)) {

            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(a, b));

        } else if ("char".equalsIgnoreCase(dataType)) {

            char symbol1 = scanner.nextLine().charAt(0);
            char symbol2 = scanner.nextLine().charAt(0);
            System.out.println(getMax(symbol1, symbol2));

        } else if ("String".equalsIgnoreCase(dataType)) {

            String firstText = scanner.nextLine();
            String secondText = scanner.nextLine();
            System.out.println(getMax(firstText, secondText));

        }

    }

    static int getMax(int firstNum,int secondNum){
        if(firstNum > secondNum) {

            return firstNum;
        }

        return secondNum;
    }

    static char getMax(char firstSymbol, char secondSymbol){

        if(firstSymbol > secondSymbol) {

            return firstSymbol;
        }

        return secondSymbol;
    }

    static String getMax(String firstText, String secondText) {

//        int first = firstText.compareTo(secondText);
//        if (first >=0) {
//            return firstText;
//        }
        if (firstText.compareTo(secondText) >= 0){
            return firstText;
        }

        return secondText;
    }
}
