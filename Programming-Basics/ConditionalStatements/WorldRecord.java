package conditionalStatements;

import java.util.Scanner;

public class WorldRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeOneMeter = Double.parseDouble(scanner.nextLine());

        double timeWithout = distance * timeOneMeter;
        double every15 = Math.floor(distance / 15);
        double plusTime = every15 * 12.5;
        double wholeTime = timeWithout + plusTime;

        if (wholeTime < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", wholeTime);
        }else if (wholeTime >= record) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", (wholeTime - record));
        }

    }
}
