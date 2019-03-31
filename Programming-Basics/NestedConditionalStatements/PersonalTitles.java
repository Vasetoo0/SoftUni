package nestedConditionalStatements;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();

        String title = "";

        if (gender.equals("m")) {
            if (age < 16){
                title = "Master";
            }else {
                title = "Mr.";
            }
        }else {
            if (age < 16) {
                title = "Miss";
            }else {
                title = "Ms.";
            }
        }

        System.out.println(title);

    }
}
