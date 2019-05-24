package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expr = scanner.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {

            if('(' == expr.charAt(i)) {
                indexes.push(i);
            } else if (')' == expr.charAt(i)) {
                System.out.println(expr.substring(indexes.pop(), i + 1));
            }
        }
    }

}
