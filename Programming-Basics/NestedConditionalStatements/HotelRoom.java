package nestedConditionalStatements;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double apartmentPrice = 0;
        double studioPrice = 0;

        if ("May".equals(month) || "October".equals(month)) {
            studioPrice = nightsCount * 50;
            apartmentPrice = nightsCount * 65;
        } else if ("June".equals(month) || "September".equals(month)) {
            studioPrice = nightsCount * 75.20;
            apartmentPrice = nightsCount * 68.70;
        } else {
            studioPrice = nightsCount * 76;
            apartmentPrice = nightsCount * 77;
        }

        if (nightsCount > 7 && nightsCount <= 14) {
            if("May".equals(month) || "October".equals(month)) {
                studioPrice = studioPrice - (studioPrice * 0.05);
            }
        } else if (nightsCount > 14) {
            apartmentPrice = apartmentPrice - (apartmentPrice * 0.10);
            if ("May".equals(month) || "October".equals(month)) {
                studioPrice = studioPrice - (studioPrice * 0.30);
            } else if ("June".equals(month) || "September".equals(month)) {
                studioPrice = studioPrice - (studioPrice * 0.20);
            }
        }

        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", apartmentPrice, studioPrice);


    }
}
