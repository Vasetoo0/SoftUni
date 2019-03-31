package Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {

            numbers.add(Double.parseDouble(input[i]));
        }

        for (int i = 0; i < numbers.size()-1; i++) {

            double firstNum = numbers.get(i);
            double nextNum = numbers.get(i + 1);
            if (firstNum == nextNum) {

                numbers.set(i, firstNum + nextNum);
                numbers.remove(i + 1);

                i = -1;

            }
        }

        String output = joinElements(numbers);
        System.out.println(String.join(" ", output));

    }

    static String joinElements(List<Double> items) {

        String output = "";
        DecimalFormat format = new DecimalFormat("0.#");

        for (Double item : items) {

            output += format.format(item) + " ";
        }

        return output;
    }
}
