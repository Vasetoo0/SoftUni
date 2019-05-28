package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEdintor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String currText = "";

        ArrayDeque<String> undoes = new ArrayDeque<>();


        for (int i = 0; i < count; i++) {

            String[] data = scanner.nextLine().split("\\s+");

            String command = data[0];


            switch (command) {
                case "1":
                    undoes.push(currText);
                    String elements = data[1];

                    currText += elements;

                    break;
                case "2":
                    undoes.push(currText);
                    int elementsToErase = Integer.parseInt(data[1]);

                    for (int j = 0; j < elementsToErase; j++) {
                        currText = currText.substring(0, currText.length() - 1);
                    }
                    break;
                case "3":
                    int indexToShow = Integer.parseInt(data[1]);

                    try {
                        System.out.println(currText.charAt(indexToShow - 1));

                    } catch (Exception e) {

                    }
                    break;
                case "4":
                    currText = undoes.pop();
                    break;
            }
        }
    }
}
