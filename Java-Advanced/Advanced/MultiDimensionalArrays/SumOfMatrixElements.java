package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        System.out.println(matrixRows);
        System.out.println(matrixCols);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int cols = 0; cols < numbers.length; cols++) {
                int number = numbers[cols];
                matrix[rows][cols] = number;

            }
        }

        int sum = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
               sum += anInt;
            }
        }
        System.out.println(sum);

    }
}
