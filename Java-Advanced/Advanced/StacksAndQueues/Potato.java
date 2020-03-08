package Advanced.StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> childs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> removed = new ArrayDeque<>();

        int index = -1;
        while (childs.size() != 1) {

            for (int i = 1; i <= n; i++) {
                index++;
                if (index > childs.size() - 1) {
                    index = 0;
                }
            }

            removed.offer(childs.get(index));
            childs.remove(index);

            if(index <= childs.size() -1) {
                index--;
            } else if(index > childs.size() - 1) {
                index = -1;
            }


        }

        while (removed.size() != 0) {
            System.out.println("Removed" + " " + removed.poll());
        }

        childs.forEach(e -> System.out.println(String.format("Last is %s",e)));
    }

}

