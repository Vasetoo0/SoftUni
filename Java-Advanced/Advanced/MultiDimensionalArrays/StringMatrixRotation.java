package Advanced.MultiDimensionalArrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Pattern pattern = Pattern.compile("Rotate\\((?<degree>[0-9]+)\\)");
        Matcher matcher = pattern.matcher(command);
        int degreeToRotate = 0;
        if (matcher.find()) {

            degreeToRotate = Integer.parseInt(matcher.group("degree"));
        }

        ArrayList<String> words = new ArrayList<>();

        int cols = Integer.MIN_VALUE;

        String input;
        while (!"END".equals(input = scanner.nextLine())) {

            if (cols < input.length()) {
                cols = input.length();
            }

            words.add(input);

        }
        int rows = words.size();

        char[][] matrix1 = fillMatrix(words, rows, cols);

        if((degreeToRotate / 90) % 4 == 1) {
            int currCols = 0;
            for (int row = 0; row < cols; row++) {
                int currRows = rows - 1;
                for (int col = 0; col < rows; col++) {
                    System.out.print(matrix1[currRows--][currCols]);
                }
                System.out.println();
                currCols++;
            }
        } else if ((degreeToRotate / 90) % 4 == 2) {
            int currRow = rows - 1;
            for (int row = 0; row < rows; row++) {
                int currCol = cols - 1;
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix1[currRow][currCol--]);
                }
                System.out.println();
                currRow--;

            }
        } else if ((degreeToRotate / 90) % 4 == 3) {
            int currCols = cols - 1;
            for (int row = 0; row < cols; row++) {
                int currRows = 0;
                for (int col = 0; col < rows; col++) {
                    System.out.print(matrix1[currRows++][currCols]);
                }
                System.out.println();
                currCols--;
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix1[row][col]);
                }
                System.out.println();

            }
        }


    }

    private static char[][] fillMatrix(ArrayList<String> words, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                matrix[i][j] = words.get(i).charAt(j);

            }
            if (words.get(i).length() < cols) {
                for (int j = words.get(i).length(); j < cols; j++) {
                    matrix[i][j] = ' ';

                }
            }
        }
        return matrix;
    }

}
