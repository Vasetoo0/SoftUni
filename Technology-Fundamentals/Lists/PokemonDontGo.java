package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int removedSum = 0;

        while (numbers.size() > 0) {
            int numberToRemove = 0;

            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {

                index = 0;
                if (numbers.size() == 1) {
                    removedSum += numbers.get(index);
                }
                numberToRemove = numbers.get(index);
                removeAndCopy(numbers, index);
                if(numbers.size() < 1) {
                    break;
                }
                removedSum += numberToRemove;
                increaseDecrease(numbers, numberToRemove);

            } else if (index > numbers.size()-1) {

                index = numbers.size()-1;
                if (numbers.size() == 1) {
                    removedSum += numbers.get(index);
                }
                numberToRemove = numbers.get(index);
                removeAndCopy(numbers, index);
                if(numbers.size() < 1) {
                    break;
                }
                removedSum += numberToRemove;
                increaseDecrease(numbers, numberToRemove);

            } else {

                numberToRemove = numbers.get(index);
                removedSum += numberToRemove;

                numbers.remove(index);
                if(numbers.size() < 1) {
                    break;
                }

                increaseDecrease(numbers, numberToRemove);

            }
        }

        System.out.println(removedSum);
    }

    private static List<Integer> increaseDecrease(List<Integer> numbers, int numberToRemove) {

        for (int i = 0; i < numbers.size(); i++) {
            int numberToCompare = 0;

            if(numbers.get(i) <= numberToRemove) {
                numberToCompare = numbers.get(i);
                numbers.set(i, numberToCompare + numberToRemove);
            } else {
                numberToCompare = numbers.get(i);
                numbers.set(i, numberToCompare - numberToRemove);
            }
        }
        return numbers;
    }

    private static List<Integer> removeAndCopy(List<Integer> numbers, int index) {

        if(numbers.size() <= 1) {
            numbers.add(index, numbers.get(index));
            numbers.remove(index);
            return numbers;
        }

        if (index == 0) {
            numbers.remove(index);
            numbers.add(index, numbers.get(numbers.size()-1));
            return numbers;

        } else {
            numbers.remove(index);
            numbers.add(index, numbers.get(0));

            return numbers;
        }
    }
}
