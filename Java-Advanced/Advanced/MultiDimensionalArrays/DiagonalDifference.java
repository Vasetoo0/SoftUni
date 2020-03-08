package Advanced.MultiDimensionalArrays;

import java.util.Scanner;
import java.util.regex.Matcher;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int rows = 0; rows < matrixSize; rows++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < matrixSize; cols++) {
                int number = Integer.parseInt(elements[cols]);
                matrix[rows][cols] = number;
            }
        }


        int primaryDiagonalSum = 0;
        for (int i = 0; i < matrixSize; i++) {
            primaryDiagonalSum += matrix[i][i];
        }



        int secondaryDiagonalSum = 0;
        for (int i = matrixSize - 1; i >= 0; i--) {
            secondaryDiagonalSum += matrix[i][matrixSize - (i+1)];
        }

        int diff = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        System.out.println(diff);
    }

}
