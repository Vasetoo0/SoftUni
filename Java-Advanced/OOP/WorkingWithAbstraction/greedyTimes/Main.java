
package OOP.WorkingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeData = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safeData.length; i += 2) {
            String name = safeData[i];
            long quantity = Long.parseLong(safeData[i + 1]);

            String treasure = "";

            if (name.length() == 3) {
                treasure = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                treasure = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                treasure = "Gold";
            }

            if (treasure.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + quantity) {
                continue;
            }

            switch (treasure) {
                case "Gem":
                    if (!bag.containsKey(treasure)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(treasure).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(treasure)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(treasure).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(treasure)) {
                bag.put((treasure), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(treasure).containsKey(name)) {
                bag.get(treasure).put(name, 0L);
            }


            bag.get(treasure).put(name, bag.get(treasure).get(name) + quantity);
            if (treasure.equals("Gold")) {
                gold += quantity;
            } else if (treasure.equals("Gem")) {
                gems += quantity;
            } else if (treasure.equals("Cash")) {
                cash += quantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}