package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] input = scanner.nextLine().split("\\s+");

       ArrayDeque<String> elements = new ArrayDeque<>();


        for (int i = input.length-1; i >= 0; i--) {
            elements.push(input[i]);
        }

        while (elements.size() > 1) {

            int firstNum = Integer.parseInt(elements.pop());
            String operation = elements.pop();
            int secondNum = Integer.parseInt(elements.pop());



            if("+".equals(operation)) {

                elements.push(firstNum + secondNum + "");
            } else {
                elements.push(firstNum - secondNum + "");
            }

        }

        System.out.println(String.join("", elements));


    }

}
