package Advanced.SetsAndMaps;

import java.util.*;

public class HandsOFCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input;

        while (!"JOKER".equals(input = scanner.nextLine())) {

            String[] data = input.split(": ");

            String playerName = data[0];
            String[] playerCards = data[1].split(", ");

            players.putIfAbsent(playerName, new LinkedHashSet<>());

            for (String playerCard : playerCards) {
                players.get(playerName).add(playerCard);
            }
        }

        for (Map.Entry<String, Set<String>> kvp : players.entrySet()) {
            int firstCardValue = 0;
            int secondCardValue = 0;

            int cardsSum = 0;

            for (String e : kvp.getValue()) {
                boolean isTen = e.charAt(0) == '1' && e.charAt(1) == '0';
                if (Character.isDigit(e.charAt(0)) || isTen) {
                    if(isTen) {
                        firstCardValue = 10;
                    } else {

                        firstCardValue = Integer.parseInt(String.valueOf(e.charAt(0)));
                    }
                } else {
                    switch (e.charAt(0)) {
                        case 'J':
                            firstCardValue = 11;
                            break;
                        case 'Q':
                            firstCardValue = 12;
                            break;
                        case 'K':
                            firstCardValue = 13;
                            break;
                        case 'A':
                            firstCardValue = 14;
                            break;
                    }
                }
                if(isTen) {
                    switch (e.charAt(2)) {
                        case 'S':
                            secondCardValue = 4;
                            break;
                        case 'H':
                            secondCardValue = 3;
                            break;
                        case 'D':
                            secondCardValue = 2;
                            break;
                        case 'C':
                            secondCardValue = 1;
                            break;
                    }
                } else {

                    switch (e.charAt(1)) {
                        case 'S':
                            secondCardValue = 4;
                            break;
                        case 'H':
                            secondCardValue = 3;
                            break;
                        case 'D':
                            secondCardValue = 2;
                            break;
                        case 'C':
                            secondCardValue = 1;
                            break;
                    }
                }
                cardsSum += (firstCardValue * secondCardValue);

            }
            System.out.println(String.format("%s: %s",kvp.getKey(), cardsSum));
        }
    }
}
