package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> articleQueue = new ArrayDeque<>();

        String input;

        while (!"print".equalsIgnoreCase(input = scanner.nextLine())) {

            if("cancel".equalsIgnoreCase(input)) {
                if(articleQueue.size() > 0) {
                    System.out.println(String.format("Canceled %s", articleQueue.poll()));
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                articleQueue.offer(input);
            }
        }

        while (articleQueue.size() != 0) {
            System.out.println(articleQueue.poll());
        }

    }

}
