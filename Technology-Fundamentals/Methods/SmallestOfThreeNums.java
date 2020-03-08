package Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestOfThreeNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());
        int thirdNumber = Integer.parseInt(reader.readLine());

        int minNumber = Math.min(min(firstNumber, secondNumber), thirdNumber);

        System.out.println(minNumber);

    }

    static int min(int first, int second) {

        return Math.min(first, second);
    }
}
