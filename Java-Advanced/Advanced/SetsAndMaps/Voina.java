package Advanced.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = playerCardsValue(scanner.nextLine());
        Set<Integer> secondPlayerCards = playerCardsValue(scanner.nextLine());

        for (int i = 0; i < 50; i++) {
            if(secondPlayerCards.isEmpty() || firstPlayerCards.isEmpty()) {
                break;
            }

            Iterator<Integer> firstPlayerIterator = firstPlayerCards.iterator();
            Iterator<Integer> secondPlayerIterator = secondPlayerCards.iterator();

            int firstPlayerCard = firstPlayerIterator.next();
            firstPlayerCards.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerIterator.next();
            secondPlayerCards.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            }else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            } else {
                firstPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            }
        }

        if(firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }






        System.out.println();
    }

    private static LinkedHashSet<Integer> playerCardsValue(String nextLine) {
        LinkedHashSet<Integer> playerCards = new LinkedHashSet<>();
        Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(playerCards::add);
        return playerCards;
    }

}
