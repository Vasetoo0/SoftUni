package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerHand = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayerHand = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (firstPlayerHand.size() != 0 || secondPlayerHand.size() != 0){

            if (firstPlayerHand.size() == 0 || secondPlayerHand.size() == 0) {
                break;
            }

            int firstPlayerCard = firstPlayerHand.get(0);
            int secondPlayerCard = secondPlayerHand.get(0);

            if (firstPlayerCard > secondPlayerCard) {

                firstPlayerHand.add(firstPlayerCard);
                firstPlayerHand.add(secondPlayerCard);

                firstPlayerHand.remove(0);
                secondPlayerHand.remove(0);

            } else if (secondPlayerCard > firstPlayerCard) {

                secondPlayerHand.add(secondPlayerCard);
                secondPlayerHand.add(firstPlayerCard);

                secondPlayerHand.remove(0);
                firstPlayerHand.remove(0);
            } else {

                firstPlayerHand.remove(0);
                secondPlayerHand.remove(0);

            }
        }

        if (firstPlayerHand.size() != 0) {

            int sum = 0;

            for (Integer card : firstPlayerHand) {

                sum += card;
            }

            System.out.printf("First player wins! Sum: %d", sum);

        } else if (secondPlayerHand.size() != 0) {

            int sum = 0;

            for (Integer integer : secondPlayerHand) {

                sum += integer;
            }

            System.out.printf("Second player wins! Sum: %d", sum);

        }

    }
}
