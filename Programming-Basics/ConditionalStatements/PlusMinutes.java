package conditionalStatements;

import java.util.Scanner;

public class PlusMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine()) + 15;

        if (min > 59) {
            hours++;
            min = min - 60;
            if (hours > 23) {
                hours = 0;
            }
        }

        if (min < 10){
            System.out.println(hours + ":0" + min);
        }else {
            System.out.println(hours + ":" + min);
        }



    }
}
