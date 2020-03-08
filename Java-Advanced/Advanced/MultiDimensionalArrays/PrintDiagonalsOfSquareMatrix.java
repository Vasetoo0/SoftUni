package Advanced.MultiDimensionalArrays;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] squareMatrix = new String[n][n];

        for (int rows = 0; rows < squareMatrix.length; rows++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < elements.length; cols++) {

                squareMatrix[rows][cols] = elements[cols];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(squareMatrix[i][i] + " ");
        }
        System.out.println();
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(squareMatrix[i][n - (i+1)] + " ");
        }
    }

}
