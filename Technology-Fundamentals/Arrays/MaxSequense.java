package Arrays;

import java.util.Scanner;

public class MaxSequense {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int maxCounter = 0;
        int maxIndex = 0;
        String sequenceNumber = "";

        for (int i = 0; i < numbers.length; i++) {
            int currentCounter = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    currentCounter++;
                    if (currentCounter > maxCounter) {
                        maxCounter = currentCounter;
                        maxIndex = i;
                        sequenceNumber = Integer.toString(numbers[i]);
                    }
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < maxCounter; i++) {
            System.out.print(sequenceNumber + " ");
        }






    }
}
