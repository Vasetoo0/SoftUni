package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        for (String num : nums) {
            numStack.push(Integer.parseInt(num));
        }

        while (numStack.size() > 0) {

            System.out.print(numStack.pop() + " ");
        }

    }

}
