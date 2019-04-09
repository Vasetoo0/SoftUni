package DemoTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kids = Arrays.stream(scanner.nextLine().split("[&]"))
                .collect(Collectors.toList());

        String input = "";

        while (!"Finished!".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            String command = data[0];
            String kidName = data[1];

            switch (command) {
                case "Bad":

                    if(!kidExist(kids, kidName)) {
                        kids.add(0, kidName);
                    }
                    break;
                case "Good":

                    if(kidExist(kids, kidName)) {
                        kids.remove(kidName);
                    }
                    break;
                case "Rename":

                    String oldName = data[1];
                    String newName = data[2];

                    if(kidExist(kids, oldName)) {
                        kids.set(kids.indexOf(oldName), newName);
                    }

                    break;
                case "Rearrange":

                    if (kidExist(kids, kidName)) {
                        kids.remove(kidName);
                        kids.add(kidName);
                    }

                    break;
            }
        }

        System.out.println(String.join(", ", kids));
    }

    private static boolean kidExist(List<String> kids, String kidName) {

        for (int i = 0; i < kids.size(); i++) {
            if(kids.get(i).equalsIgnoreCase(kidName)) {
                return true;
            }
        }
        return false;
    }

}
