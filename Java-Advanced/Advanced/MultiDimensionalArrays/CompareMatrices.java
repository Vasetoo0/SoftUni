package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRows = dimentions[0];
        int firstMatrixCols = dimentions[1];

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];
        for (int rows = 0; rows < firstMatrixRows; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int cols = 0; cols < firstMatrixCols; cols++) {
                int number = numbers[cols];
                firstMatrix[rows][cols] = number;
            }
        }
        dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sesondMatrixRows = dimentions[0];
        int secondMatrixCols = dimentions[1];

        if(firstMatrixRows != sesondMatrixRows) {
            System.out.println("not equal");
            return;
        } else if (firstMatrixCols != secondMatrixCols) {
            System.out.println("not equal");
            return;
        }

        int[][] secondMatrix = new int[firstMatrixRows][firstMatrixCols];
        for (int rows = 0; rows < sesondMatrixRows; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int cols = 0; cols < secondMatrixCols; cols++) {
                int number = numbers[cols];
                secondMatrix[rows][cols] = number;
            }
        }

        for (int rows = 0; rows < firstMatrixRows; rows++) {
            for (int cols = 0; cols < firstMatrixCols; cols++) {
                if(firstMatrix[rows][cols] != secondMatrix[rows][cols]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");


    }

}
