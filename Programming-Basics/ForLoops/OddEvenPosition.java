package forLoops;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddMax = Integer.MIN_VALUE;
        double oddMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        double evenMin = Integer.MAX_VALUE;

        double oddSum = 0;
        double evenSum = 0;


        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());


            if (i % 2 != 0) {
                oddSum += num;
                if (num > oddMax) {
                    oddMax = num;
                }
                if (num < oddMin) {
                    oddMin = num;
                }
            } else {
                evenSum += num;
                if (num > evenMax) {
                    evenMax = num;
                }
                if (num < evenMin) {
                    evenMin = num;
                }
            }

        }

        DecimalFormat df = new DecimalFormat("#.###");
        if (n == 0) {
            System.out.printf("OddSum=%s,%nOddMin=No,%nOddMax=No,%nEvenSum=%s,%nEvenMin=No,%nEvenMax=No",df.format(oddSum), df.format(evenSum));
        } else if (n <= 1) {
            System.out.printf("OddSum=%s,%nOddMin=%s,%nOddMax=%s,%nEvenSum=%s,%nEvenMin=No,%nEvenMax=No",df.format(oddSum),df.format(oddMin),df.format(oddMax), df.format(evenSum));
        } else {
            System.out.printf("OddSum=%s,%n", df.format(oddSum));
            System.out.printf("OddMin=%s,%n",df.format(oddMin));
            System.out.printf("OddMax=%s,%n", df.format(oddMax));
            System.out.printf("EvenSum=%s,%n", df.format(evenSum));
            System.out.printf("EvenMin=%s,%n", df.format(evenMin));
            System.out.printf("EvenMax=%s,", df.format(evenMax));
        }
    }
}
