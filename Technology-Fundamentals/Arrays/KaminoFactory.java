package Arrays;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        String input = "";


        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int sequenceSampleCount = 0;
        int bestSequenceSample = 0;
        String sequenceOutput = "";

        while (!"Clone them!".equals(input = scanner.nextLine())) {
            ++sequenceSampleCount;

            String[] data = input.split("!+");

            int[] sequenceDNA = new int[size];

            for (int i = 0; i < data.length; i++) {
                sequenceDNA[i] = Integer.parseInt(data[i]);
            }


            int maxCounter = 0;
            int sequenceIndex = 0;

            for (int i = 0; i < sequenceDNA.length; i++) {
                int currentCounter = 0;


                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == sequenceDNA[j]) {
                        currentCounter++;
                        if (currentCounter > maxCounter) {
                            maxCounter = currentCounter;
                            sequenceIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            int sequenceSum = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                if (sequenceDNA[i] == 1) {
                    sequenceSum += sequenceDNA[i];
                }
            }

            if (sequenceIndex < bestSequenceIndex || sequenceSum > bestSequenceSum) {
                sequenceOutput = "";
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestSequenceSample = sequenceSampleCount;
                for (int i = 0; i < sequenceDNA.length; i++) {
                    sequenceOutput += sequenceDNA[i] + " ";
                }
            }
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSequenceSample, bestSequenceSum);
        System.out.println(sequenceOutput.trim());

    }
}
