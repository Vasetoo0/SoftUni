package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        for (int i = 0; i < words.length / 2; i++) {
            String word = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = word;

        }

        System.out.println(String.join(" ", words));



    }
}
