package Methods;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(matrix(n));
        }



    }

    static String matrix(int n) {

        String filledMatrix = "";
            for (int i = 0; i < n; i++) {
                filledMatrix += n + " ";
            }
            return filledMatrix;
    }
}