package DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SpiceMustFlow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dayYield = Integer.parseInt(reader.readLine());

        int spiceMined = 0;
        int daysOperated = 0;

        while (dayYield >= 100) {
            spiceMined += dayYield - 26;
            dayYield -= 10;
            daysOperated++;
        }

        if (spiceMined != 0) {
            spiceMined -= 26;
        }

            System.out.println(daysOperated);
            System.out.print(spiceMined);





    }
}
