    package Advanced.FuctionalProgramming;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.function.UnaryOperator;

    public class AddVAT {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            UnaryOperator<Double> pricePlusVAT = price -> 1.2 * price;

            String[] prices = reader.readLine().split(", ");

            System.out.println("Prices with VAT:");

            Arrays.stream(prices)
                    .mapToDouble(Double::parseDouble)
                    .forEach(price -> System.out.println(String.format("%.2f",pricePlusVAT.apply(price))));
        }

    }
