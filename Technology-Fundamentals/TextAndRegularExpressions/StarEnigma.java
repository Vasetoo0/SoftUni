package TextAndRegularExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> atacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String message = scanner.nextLine();

            int keyCount = 0;

            Pattern starPattern = Pattern.compile("[starSTAR]+");
            Matcher starMatch = starPattern.matcher(message);

            StringBuilder starChars = new StringBuilder();



            while (starMatch.find()) {

                starChars.append(starMatch.group());

            }

            int decryptionKey = starChars.length();

            String decryptedMessage = "";

            for (int k = 0; k < message.length(); k++) {

                int decryptedSymbol = message.charAt(k) - decryptionKey;

                char symbol = (char)decryptedSymbol;

                decryptedMessage += symbol;

            }

            Pattern decryptedPattern = Pattern.compile("@(?<name>[A-Za-z]+)([^\\:@\\!\\->]*):" +
                    "(?<population>[0-9]+)([^\\:@\\!\\->]*)!" +
                    "(?<attackType>[AD])!([^\\:@\\!\\->]*)->" +
                    "(?<soldierCount>[0-9]+)");

            Matcher decryptedMatch = decryptedPattern.matcher(decryptedMessage);

            if (decryptedMatch.find()) {

                if(decryptedMatch.group("attackType").equalsIgnoreCase("A")) {
                    atacked.add(decryptedMatch.group("name"));
                } else {
                    destroyed.add(decryptedMatch.group("name"));
                }
            }
        }

        System.out.println(String.format("Attacked planets: %d", atacked.size()));
        Collections.sort(atacked);
        for (String attackedPlanet : atacked) {
            System.out.println(String.format("-> %s", attackedPlanet));
        }
        System.out.println(String.format("Destroyed planets: %d", destroyed.size()));
        Collections.sort(destroyed);
        for (String destroyedPlanet : destroyed) {
            System.out.println(String.format("-> %s", destroyedPlanet));
        }
    }
}
