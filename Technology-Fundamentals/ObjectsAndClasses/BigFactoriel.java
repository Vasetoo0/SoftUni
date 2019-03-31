package ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactoriel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));

            result = result.multiply(num);

        }

        System.out.println(result);

    }
}
