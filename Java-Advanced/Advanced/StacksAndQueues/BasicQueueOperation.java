package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int toOffer = commands.get(0);
        int toPoll = commands.get(1);
        int element = commands.get(2);

        if(toOffer == 0) {
            System.out.println(0);
            return;
        }

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> elementStack = new ArrayDeque<>();

        for (int e : elements) {

            elementStack.offer(e);

        }

        for (int i = 0; i < toPoll; i++) {
            elementStack.poll();
        }

        if(elementStack.contains(element)) {
            System.out.println("true");
        } else {
            if(elementStack.size() == 0) {
                System.out.println(0);
            } else {
                int minEleent = Integer.MAX_VALUE;
                for (Integer integer : elementStack) {
                    if(integer < minEleent) {
                        minEleent = integer;
                    }
                }

                System.out.println(minEleent);
            }
        }




    }

}
