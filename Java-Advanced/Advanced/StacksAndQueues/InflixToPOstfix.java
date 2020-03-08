package Advanced.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InflixToPOstfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> operandStack = new ArrayDeque<>();

        String[] expression = scanner.nextLine().split(" ");


        for (int i = 0; i < expression.length; i++) {
            boolean isOperand = expression[i].equals("+")
                    || expression[i].equals("-")
                    || expression[i].equals("*")
                    || expression[i].equals("/");
            if (Character.isDigit(expression[i].charAt(0)) || Character.isLetter(expression[i].charAt(0))) {

                System.out.print(expression[i] + " ");
            } else if (isOperand) {
                String operand = expression[i];
                if (operand.equals("+") || operand.equals("-")) {
                    if (operandStack.size() > 0) {
                        if (operandStack.peek().equals("+") || operandStack.peek().equals("-")) {
                            System.out.print(operandStack.pop() + " ");
                        }
                    }
                } else if (operand.equals("*") || operand.equals("/")) {
                    if (operandStack.size() > 0) {
                        if (operandStack.peek().equals("*") || operandStack.peek().equals("/")) {
                            System.out.print(operandStack.pop() + " ");
                        }
                    }
                }
                operandStack.push(expression[i]);
            } else if (expression[i].equals("(")) {

                operandStack.push(expression[i]);

            } else if (expression[i].equals(")")) {
                System.out.print(operandStack.pop() + " ");
                operandStack.pop();
            }
        }
        for (String operand : operandStack) {
            System.out.print(operand + " ");
        }
    }

}
