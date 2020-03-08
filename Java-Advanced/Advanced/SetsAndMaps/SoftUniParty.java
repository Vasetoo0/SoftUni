package Advanced.SetsAndMaps;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input;

        while (!"PARTY".equals(input = scanner.nextLine())) {
            if(Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
        }
        while (!"END".equals(input = scanner.nextLine())) {
            if(vipGuests.contains(input) || regularGuests.contains(input)) {

                if(Character.isDigit(input.charAt(0))) {
                    vipGuests.remove(input);
                } else {
                    regularGuests.remove(input);
                }
            }
        }

        System.out.println(vipGuests.size() + regularGuests.size());



        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }

}
