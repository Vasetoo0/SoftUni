package Advanced.MultiDimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int matrRows = Integer.parseInt(dimensions[0]);
        int matrCols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[matrRows][matrCols];

        for (int rows = 0; rows < matrRows; rows++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < matrCols; cols++) {
                matrix[rows][cols] = elements[cols];
            }
        }

        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            String[] inputData = input.split("\\s+");

            if(inputData.length < 5) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                String command = inputData[0];
                int row1 = Integer.parseInt(inputData[1]);
                int col1 = Integer.parseInt(inputData[2]);
                int row2 = Integer.parseInt(inputData[3]);
                int col2 = Integer.parseInt(inputData[4]);

                if(!command.equals("swap") || row1 >= matrRows || col1 >= matrCols
                        || row2 >= matrRows || col2 >= matrCols) {
                    System.out.println("Invalid input!");
                } else {

                    String firstElementToSwap = matrix[row1][col1];
                    String secondElementToSwap = matrix[row2][col2];

                    matrix[row2][col2] = firstElementToSwap;
                    matrix[row1][col1] = secondElementToSwap;

                    for (String[] strings : matrix) {
                        for (String string : strings) {
                            System.out.print(string + " ");
                        }
                        System.out.println();
                    }

                }
            } catch (Exception e) {

                System.out.println("Invalid input!");

            }
        }
    }
}
