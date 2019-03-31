package MapsLamdbaStreamAPI;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendary = new TreeMap<>();

        legendary.put("shards", 0);
        legendary.put("fragments", 0);
        legendary.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();

        boolean haveWinner = false;

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length <= 1) {
                break;
            }

            for (int i = 0; i < input.length; i += 2) {

                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (legendary.containsKey(material)) {

                    legendary.put(material, legendary.get(material) + quantity);

                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                }

                if (material.equals("shards")) {
                    if (legendary.get(material) >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        haveWinner = true;
                        break;
                    }
                } else if (material.equals("fragments")) {
                    if (legendary.get(material) >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        haveWinner = true;
                        break;
                    }
                } else if (material.equals("motes")) {
                    if (legendary.get(material) >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        haveWinner = true;
                        break;
                    }
                }
            }
            if (haveWinner) {
                break;
            }
        }
        legendary.entrySet()
                .stream()
                .sorted(((a,b) -> //b.getValue().compareTo(a.getValue())
                                    Integer.compare(b.getValue(), a.getValue())))
                .forEach(l -> System.out.println(String.format("%s: %d", l.getKey(), l.getValue())));

        junk.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));



    }
}
