import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] prices = reader.readLine().split(",\\s+");

        UnaryOperator<Double> addVat = d -> d * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(x -> System.out.println(String.format("%.2f", x)));

    }
}
