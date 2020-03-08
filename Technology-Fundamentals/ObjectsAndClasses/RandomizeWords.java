package ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int posTwo = random.nextInt(words.length);

            String swapWord = words[i];
            words[i] = words[posTwo];
            words[posTwo] = swapWord;
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
