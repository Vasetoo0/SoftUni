package nestedLoops;

import java.util.Scanner;

public class MagicNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k < 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        for (int m = 1; m <= 9; m++) {
                            for (int n = 1; n <= 9; n++) {
                                if (i * j * k * l * m * n == magicNum) {
                                    System.out.print("" + i + j + k + l + m + n + " ");
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
