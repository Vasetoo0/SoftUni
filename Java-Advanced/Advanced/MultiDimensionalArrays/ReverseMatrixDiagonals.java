package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matRows = scanner.nextInt();
        int matCols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[matRows][matCols];

        for (int row = 0; row < matRows; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int rows = matRows -1;
        int cols = matCols -1;

        while (rows >= 0) {

            int row = rows;
            int col = cols;

            while (col < matCols && row >= 0) {

                System.out.print(matrix[row--][col++] + " ");
            }
            System.out.println();

            cols--;
            if(cols == -1) {
                cols = 0;
                rows--;
            }
        }
    }

}
