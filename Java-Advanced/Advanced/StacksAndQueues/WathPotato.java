package Advanced.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class WathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {

            queue.offer(child);
        }

        while (queue.size() > 1) {

            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());

            }
            System.out.println("Removed" + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }

}

