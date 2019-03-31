package conditionalStatements;

import java.util.Scanner;

public class Surprise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstSon = Double.parseDouble(scanner.nextLine());
        double secondSon = Double.parseDouble(scanner.nextLine());
        double thirdSon = Double.parseDouble(scanner.nextLine());
        double fatherTime = Double.parseDouble(scanner.nextLine());

        double timeWork = 1 / ((1 / firstSon) + (1 / secondSon) + (1 / thirdSon));
        double wholeTime = timeWork + (timeWork * 0.15);
        double timeLeft = Math.abs(fatherTime - wholeTime);

        System.out.printf("Cleaning time: %.2f%n", wholeTime);


        if (wholeTime < fatherTime) {
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", Math.floor(timeLeft));
        }else if (wholeTime > fatherTime) {
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", Math.ceil(timeLeft));
        }

    }
}
