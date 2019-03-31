package IntroAndBasicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokeMon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        byte y = Byte.parseByte(reader.readLine());

        int targetsCounter = 0;
        int originalValue = n;

        while (n >= m) {
            n -= m;
            targetsCounter++;

            if (originalValue / 2 == n) {
                if (y != 0) {
                    n = n / y;
                }
            }
        }

        System.out.println(n);
        System.out.print(targetsCounter);



    }
}
