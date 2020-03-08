package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixCols = Integer.parseInt(scanner.nextLine());


        char[][] firstMatrix = new char[matrixRows][matrixCols];
        char[][] secondMatrix = new char[matrixRows][matrixCols];


        for (int rows = 0; rows < matrixRows * 2; rows++) {

            String[] elements = scanner.nextLine().split("\\s+");

            for (int cols = 0; cols < matrixCols; cols++){
                if(rows < matrixRows) {
                    firstMatrix[rows][cols] = elements[cols].charAt(0);

                } else {
                    secondMatrix[rows - matrixRows][cols] = elements[cols].charAt(0);
                }
            }
        }

        char[][] newMatrix = new char[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                char firstMatrixChar = firstMatrix[rows][cols];
                char secondMatrixChar = secondMatrix[rows][cols];

                if(firstMatrixChar != secondMatrixChar) {
                    newMatrix[rows][cols] = '*';
                } else {
                    newMatrix[rows][cols] = firstMatrixChar;
                }
            }
        }

        for (char[] chars : newMatrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();

        }

    }

}
