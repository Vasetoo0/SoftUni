package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();

        String input;

        while (!"Home".equalsIgnoreCase(input = scanner.nextLine())) {

            if ("forward".equalsIgnoreCase(input)) {

                if (forwardQueue.size() > 0) {

                    backStack.push(forwardQueue.peek());

                    System.out.println(forwardQueue.pop());
                } else {
                    System.out.println("no next URLs");
                }

            } else if ("back".equalsIgnoreCase(input)) {

                if (backStack.size() > 1) {
                    forwardQueue.push(backStack.pop());

                    System.out.println(backStack.peek());

                } else {
                    System.out.println("no previous URLs");
                }

            } else {

                forwardQueue.clear();

                backStack.push(input);

                System.out.println(input);
            }
        }
    }
}
