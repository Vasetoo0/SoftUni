package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!isBetween(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!lettersAndDigitsOnly(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!haveTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isBetween(password) && lettersAndDigitsOnly(password) && haveTwoDigits(password)) {
            System.out.println("Password is valid");
        }


    }

    static boolean isBetween(String password) {

        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    static boolean lettersAndDigitsOnly(String password) {

        boolean lettersAndDigits = false;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 'a' && symbol <= 'z'
                    || symbol >= 'A' && symbol <= 'Z'
                    || symbol >= '0' && symbol <= '9') {
                lettersAndDigits = true;
            } else {
                lettersAndDigits = false;
                break;
            }
        }
        return lettersAndDigits;
    }

    static boolean haveTwoDigits(String password) {

        int digitsCounter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= '0' && symbol <= '9') {
                digitsCounter++;
                if (digitsCounter >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
