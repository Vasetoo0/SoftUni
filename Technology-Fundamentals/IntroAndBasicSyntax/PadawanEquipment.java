package IntroAndBasicSyntax;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyHave = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabrePrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double lightsabresCount = Math.ceil(studentsCount + (studentsCount * 0.10));


        int freeBelts = studentsCount / 6;

        double moneyNeeded = (lightsabresCount * lightsabrePrice) + (studentsCount * robesPrice) + ((studentsCount - freeBelts) * beltsPrice);

        double diff = Math.abs(moneyHave - moneyNeeded);

        if (moneyNeeded <= moneyHave) {
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", diff);
        }
    }
}
