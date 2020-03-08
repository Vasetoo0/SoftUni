package Advanced.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> contacts = new LinkedHashMap<>();

        String input;

        while (!"search".equals(input = scanner.nextLine())) {

            String[] info = input.split("-");

            String contactName = info[0];
            String contactNumber = info[1];

                contacts.put(contactName,contactNumber);
        }

        while (!"stop".equals(input = scanner.nextLine())) {

            if(contacts.containsKey(input)) {
                System.out.println(String.format("%s -> %s", input, contacts.get(input)));
            } else {
                System.out.println(String.format("Contact %s does not exist.",input));
            }


        }
    }

}
