package Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!"end".equalsIgnoreCase(input)) {

            String[] command = input.split("\\s+");

            if ("exchange".equalsIgnoreCase(command[0])) {

                int indexToExchange = Integer.parseInt(command[1]);

                if (indexToExchange >= numbers.length || indexToExchange < 0) {

                    System.out.println("Invalid index");

                } else {

                    numbers = exchange(numbers, indexToExchange);
                }


            } else if ("max".equalsIgnoreCase(command[0])) {

                String maxCommand = command[1];

                if ("even".equalsIgnoreCase(maxCommand)) {

                    maxEvenOdd(numbers, maxCommand);

                } else if ("odd".equalsIgnoreCase(maxCommand)) {

                    maxEvenOdd(numbers, maxCommand);
                }
            } else if ("min".equalsIgnoreCase(command[0])) {

                String minCommand = command[1];

                if ("even".equalsIgnoreCase(minCommand)) {

                    minEvenOdd(numbers, minCommand);

                } else if ("odd".equalsIgnoreCase(minCommand)) {

                    minEvenOdd(numbers, minCommand);

                }
            } else if ("first".equalsIgnoreCase(command[0])) {

                int count = Integer.parseInt(command[1]);
                String evenOddCommand = command[2];

                if ("even".equalsIgnoreCase(evenOddCommand)) {

                    firstEvenOdd(numbers, count, evenOddCommand);

                } else if ("odd".equalsIgnoreCase(evenOddCommand)) {

                    firstEvenOdd(numbers, count, evenOddCommand);
                }
            } else if ("last".equalsIgnoreCase(command[0])) {

                int count = Integer.parseInt(command[1]);
                String evenOddCommand = command[2];

                if ("even".equalsIgnoreCase(evenOddCommand)) {

                    lastEvenOdd(numbers, count, evenOddCommand);
                } else if ("odd".equalsIgnoreCase(evenOddCommand)) {

                    lastEvenOdd(numbers, count, evenOddCommand);
                }
            }

            input = scanner.nextLine();

        }

        List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {

            newRow.add(numbers[i]);
        }

        System.out.println(newRow);

    }

    static int[] exchange(int[] numbers, int index) {

        int[] firstHalf = new int[index + 1];
        int[] secondHalf = new int[numbers.length - (index + 1)];

        for (int i = 0; i <= index; i++) {
            firstHalf[i] = numbers[i];
        }
        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = numbers[index + 1 + i];
        }

        int[] newArray = new int[firstHalf.length + secondHalf.length];

        for (int i = 0; i < secondHalf.length; i++) {
            newArray[i] = secondHalf[i];
        }

        for (int i = 0; i < firstHalf.length; i++) {
            newArray[secondHalf.length + i] = firstHalf[i];
        }

        return newArray;
    }

    static void maxEvenOdd(int[] numbers, String command) {

        int maxEvenOdd = Integer.MIN_VALUE;
        int maxEvenOddIndex = 0;
        int maxEvenOddCounter = 0;

        if ("even".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0 && numbers[i] >= maxEvenOdd) {

                    maxEvenOdd = numbers[i];
                    maxEvenOddIndex = i;
                    maxEvenOddCounter++;
                }

            }
        } else if ("odd".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0 && numbers[i] >= maxEvenOdd) {

                    maxEvenOdd = numbers[i];
                    maxEvenOddIndex = i;
                    maxEvenOddCounter++;
                }
            }
        }

        if (maxEvenOddCounter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenOddIndex);
        }
    }

    static void minEvenOdd(int[] numbers, String command) {

        int minEvenOdd = Integer.MAX_VALUE;
        int minEvenOddIndex = 0;
        int minEvenOddCounter = 0;

        if ("even".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0 && numbers[i] <= minEvenOdd) {

                    minEvenOdd = numbers[i];
                    minEvenOddIndex = i;
                    minEvenOddCounter++;
                }

            }
        } else if ("odd".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0 && numbers[i] <= minEvenOdd) {

                    minEvenOdd = numbers[i];
                    minEvenOddIndex = i;
                    minEvenOddCounter++;
                }
            }
        }

        if (minEvenOddCounter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenOddIndex);
        }
    }

    static void firstEvenOdd(int[] numbers, int count, String command) {

        List<Integer> evenOddNumbers = new ArrayList<>();
        int evenOddCounter = 0;


        if ("even".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (count > numbers.length || count < 0) {
                    break;
                }
                if(numbers[i] % 2 == 0) {
                    evenOddNumbers.add(numbers[i]);
                    evenOddCounter++;
                    if (evenOddCounter == count) {
                        break;
                    }
                }
            }

        } else if ("odd".equalsIgnoreCase(command)) {

            for (int i = 0; i < numbers.length; i++) {
                if (count > numbers.length || count < 0) {
                    break;
                }
                if(numbers[i] % 2 != 0) {
                    evenOddNumbers.add(numbers[i]);
                    evenOddCounter++;
                    if (evenOddCounter == count) {
                        break;
                    }
                }
            }

        }
        if (count > numbers.length || count < 0) {
            System.out.println("Invalid count");
        } else if (evenOddCounter == 0) {
            System.out.println("[]");
        } else {
            System.out.println(evenOddNumbers);
        }
    }

    static void lastEvenOdd(int[] numbers, int count, String command) {

        List<Integer> evenOddNumbers = new ArrayList<>();
        int evenOddCounter = 0;


        if ("even".equalsIgnoreCase(command)) {

            for (int i = numbers.length-count; i < numbers.length; i++) {
                if (count > numbers.length || count < 0) {
                    break;
                }
                if(numbers[i] % 2 == 0) {
                    evenOddNumbers.add(numbers[i]);
                    evenOddCounter++;
                    if (evenOddCounter == count) {
                        break;
                    }
                }
            }

        } else if ("odd".equalsIgnoreCase(command)) {

            for (int i = numbers.length-1; i >= 0; i--) {
                if (count > numbers.length || count < 0) {
                    break;
                }
                if(numbers[i] % 2 != 0) {
                    evenOddNumbers.add(numbers[i]);
                    evenOddCounter++;
                    if (evenOddCounter == count) {
                        break;
                    }
                }
            }

        }
        if (count > numbers.length || count < 0) {
            System.out.println("Invalid count");
        } else if (evenOddCounter == 0) {
            System.out.println("[]");
        } else {
            System.out.println(evenOddNumbers);
        }
    }
}