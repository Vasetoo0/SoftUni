package OOP.WorkingWithAbstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        for (int row = 1; row <= count; row++) {

            printRow(count, row);

        }

        for (int row = count - 1; row > 0; row--) {

            printRow(count, row);

        }
    }

    private static void printRow(int count, int row) {
        System.out.print(createRow(" ", count - row));
        System.out.print(createRow("* ", row));
        System.out.println();
    }

    private static String createRow(String str, int count) {

        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            sb.append(str);
        }

        return sb.toString();
    }

}
