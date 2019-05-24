package Advanced.MultiDimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matRows = scanner.nextInt();
        int matCols = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(matRows,matCols);

        String input;
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {

            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if(isInBounds(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }

            for (int c = col - radius; c <= col + radius; c++) {

                if(isInBounds(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
               matrix.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});
               if(matrix.get(r).size() == 0) {
                    matrix.remove(r);
                    r--;
               }
            }
        }

        printMatrix(matrix,matRows,matCols);

    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix, int matRows, int matCols) {
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0
                && row < matrix.size()
                && col >= 0
                && col < matrix.get(row).size();
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(int matRows, int matCols) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;
        for (int r = 0; r < matRows; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < matCols; c++) {
                row.add(value);
                value++;
            }
            matrix.add(row);
        }
        return matrix;
    }

}
