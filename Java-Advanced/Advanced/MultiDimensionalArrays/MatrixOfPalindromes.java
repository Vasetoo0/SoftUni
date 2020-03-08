package Advanced.MultiDimensionalArrays;

import java.io.StringReader;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int matrixRows = Integer.parseInt(dimensions[0]);
        int matrixCols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {

                char firstLetter = (char)('a' + rows);
                char middleLetter = (char)('a' + (rows + cols));
                char thirdLetter = (char)('a' + rows);

                String sequence = String.format("%s%s%s", Character.toString(firstLetter)
                        , Character.toString(middleLetter)
                        , Character.toString(thirdLetter));

                matrix[rows][cols] = sequence;
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }

}
