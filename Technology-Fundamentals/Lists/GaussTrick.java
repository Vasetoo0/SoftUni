package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {

            numbers.add(Integer.parseInt(input[i]));
        }

        int count = numbers.size() / 2;

        for (int i = 0; i < count; i++) {

            int firstNum = numbers.get(i);
            int lastNum = numbers.get(numbers.size() - 1);
            numbers.set(i, firstNum + lastNum);
            numbers.remove(numbers.size()-1);

        }

        System.out.println(String.join(" ", firstLastSumRow(numbers)));
    }

    static List<String> firstLastSumRow(List<Integer> numbers){

        List<String> splitNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {

            splitNumbers.add(String.valueOf(numbers.get(i)));
        }

        return splitNumbers;
    }
}
