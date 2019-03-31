package nestedLoops;

import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String wordNum = Integer.toString(num);

        for (int i = wordNum.length()-1; i >= 0 ; i--) {
            int symbolNum = wordNum.charAt(i) - 48;
            int symbol = symbolNum + 33;
            if (symbolNum == 0) {
                System.out.println("ZERO");
            } else  {
                for (int g = 1; g <= symbolNum; g++) {
                    System.out.printf("%s",(char)symbol);
                }
                System.out.println();
            }


        }
    }
}