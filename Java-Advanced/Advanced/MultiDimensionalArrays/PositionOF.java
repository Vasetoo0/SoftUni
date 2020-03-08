package Advanced.MultiDimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int matrixRows = Integer.parseInt(dimensions[0]);
        int matrixCols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int cols = 0;  cols < matrixCols; cols++) {
                int element = elements[cols];
                matrix[rows][cols] = element;
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        boolean notFound = true;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                if(number == matrix[rows][cols]) {
                    System.out.println(rows + " " + cols);
                    notFound = false;
                }

            }
        }
        if(notFound) {
            System.out.println("not found");
        }

    }

}
