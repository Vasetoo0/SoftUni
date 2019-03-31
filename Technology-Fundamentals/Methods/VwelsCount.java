package Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VwelsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();

        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            if(isVowel(input.charAt(i))) {
                counter++;
            }
        }

        System.out.println(counter);

    }

    static boolean isVowel (char symbol) {
        switch (symbol) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
        }
        return false;
    }

}
