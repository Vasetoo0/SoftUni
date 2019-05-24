package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> elementStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            String command = commands[0];

            if("1".equals(command)) {
                int numToPush = Integer.parseInt(commands[1]);
                elementStack.push(numToPush);
            } else if ("2".equals(command)) {
                elementStack.pop();
            } else {
                int maxNum = Integer.MIN_VALUE;

                for (Integer integer : elementStack) {
                    if(integer > maxNum) {
                        maxNum = integer;
                    }
                }
                System.out.println(maxNum);
            }
        }

    }

}
