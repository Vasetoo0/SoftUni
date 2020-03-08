package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine();

        ArrayDeque<Character> elementStack = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if(current == '[' || current == '{' || current == '(') {
                elementStack.push(current);
            } else {
                if(elementStack.isEmpty()) {
                    areBalanced =false;
                    break;
                }
                 char topElement = elementStack.pop();
                 if(current == ']' && topElement != '[') {
                     areBalanced = false;
                     break;

                 }else if (current == '}' && topElement != '{') {
                     areBalanced = false;
                     break;
                 } else if (current == ')' && topElement != '(') {
                     areBalanced = false;
                     break;
                 }
            }
        }
        if(areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
