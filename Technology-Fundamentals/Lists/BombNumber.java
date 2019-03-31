package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] bombAndPower = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.size(); i++) {

            for (int l = 0; l < numbers.size(); l++) {
                if (bombAndPower[0] == numbers.get(l)) {

                    for (int j = 0; j < bombAndPower[1]; j++) {

                        if (numbers.indexOf(bombAndPower[0]) - 1 < 0) {

                            break;

                        } else {

                            numbers.remove(numbers.indexOf(bombAndPower[0]) - 1);
                        }
                    }


                    for (int k = 0; k < bombAndPower[1]; k++) {

                        if (numbers.indexOf(bombAndPower[0]) + 1 > numbers.size() - 1) {
                            break;
                        } else {

                            numbers.remove(numbers.indexOf(bombAndPower[0]) + 1);
                        }
                    }

                    numbers.remove(numbers.indexOf(bombAndPower[0]));
                }
            }


        }

        int sum = 0;

        for (Integer number : numbers) {

            if (numbers.size() == 1) {
                break;
            } else {

                sum += number;
            }

        }

        System.out.println(sum);


    }
}
