package Advanced.MultiDimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(inputData[0]);
        String command = inputData[1];

        int[][] matrix = new int[matrixSize][matrixSize];


        int number = 1;
        if ("A".equals(command)) {
            for (int cols = 0; cols < matrixSize; cols++) {
                for (int rows = 0; rows < matrixSize; rows++) {
                    matrix[rows][cols] = number;
                    number++;
                }
            }
        } else {
            for (int cols = 0; cols < matrixSize; cols++) {
                if(cols % 2 == 0) {
                    for (int rows = 0; rows < matrixSize; rows++) {
                        matrix[rows][cols] = number;
                        number++;
                    }
                } else {
                    for (int rows = matrixSize - 1; rows >= 0 ; rows--) {
                        matrix[rows][cols] = number;
                        number++;
                    }
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }

}
