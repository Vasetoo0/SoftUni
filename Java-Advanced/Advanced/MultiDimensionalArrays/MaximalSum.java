package Advanced.MultiDimensionalArrays;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] dimensions = scanner.nextLine().split("\\s+");

        int matrixRows = Integer.parseInt(dimensions[0]);
        int matrixCols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < matrixCols; cols++) {
                int number = Integer.parseInt(elements[cols]);
                matrix[rows][cols] = number;

            }
        }

        int maxSum = Integer.MIN_VALUE;
        String[][] best3x3Matrix = new String[3][3];

        for (int i = 0; i < matrixRows - 2; i++) {

            for (int j = 0; j < matrixCols - 2; j++) {

                int sum = matrix[i][j]  + matrix[i][j + 1] + matrix[i][j+2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i+2][j] + matrix[i+2][j + 1] + matrix[i+2][j+2];

                if(sum > maxSum) {
                    maxSum = sum;
                    best3x3Matrix[0][0] = String.valueOf(matrix[i][j]);
                    best3x3Matrix[0][1] = String.valueOf(matrix[i][j + 1]);
                    best3x3Matrix[0][2] = String.valueOf(matrix[i][j + 2]);
                    best3x3Matrix[1][0] = String.valueOf(matrix[i + 1][j]);
                    best3x3Matrix[1][1] = String.valueOf(matrix[i + 1][j + 1]);
                    best3x3Matrix[1][2] = String.valueOf(matrix[i + 1][j + 2]);
                    best3x3Matrix[2][0] = String.valueOf(matrix[i + 2][j]);
                    best3x3Matrix[2][1] = String.valueOf(matrix[i + 2][j + 1]);
                    best3x3Matrix[2][2] = String.valueOf(matrix[i + 2][j + 2]);

                }
            }

        }
        System.out.println("Sum = " + maxSum);

        for (String[] ints : best3x3Matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
