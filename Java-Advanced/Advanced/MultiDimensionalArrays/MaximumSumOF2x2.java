package Advanced.MultiDimensionalArrays;

import java.util.Scanner;

public class MaximumSumOF2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");

        int matrixRows = Integer.parseInt(dimensions[0]);
        int matrixCols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            String[] elements = scanner.nextLine().split(", ");
            for (int cols = 0; cols < matrixCols; cols++) {
                matrix[rows][cols] = Integer.parseInt(elements[cols]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        String[][] best2x2Matrix = new String[2][2];

        for (int i = 0; i < matrixRows - 1; i++) {

            for (int j = 0; j < matrixCols - 1; j++) {

                int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];

                if(sum > maxSum) {
                    maxSum = sum;
                    best2x2Matrix[0][0] = String.valueOf(matrix[i][j]);
                    best2x2Matrix[1][0] = String.valueOf(matrix[i + 1][j]);
                    best2x2Matrix[0][1] = String.valueOf(matrix[i][j + 1]);
                    best2x2Matrix[1][1] = String.valueOf(matrix[i + 1][j + 1]);

                }
            }
        }
        for (String[] nums : best2x2Matrix) {
            for (String num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

}
