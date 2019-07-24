import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input;

        Map<String, Map<String, Double>> shop = new TreeMap<>();

        while (!"Revision".equals(input = reader.readLine())) {
            String[] tokens = input.split(",\\s+");

            String shopName = tokens[0];
            String productName = tokens[1];
            Double poructPrice = Double.parseDouble(tokens[2]);

            shop.putIfAbsent(shopName, new LinkedHashMap<>());
            shop.get(shopName).putIfAbsent(productName, poructPrice);
        }

        // fantastico-> Product: apple, Price: 1.2

        shop.forEach((shopName, product) -> {
            System.out.println(shopName + "->");
            product.forEach((productName, productPrice) -> {
                System.out.println(String.format(
                        "Product: %s, Price: %.1f",
                        productName,
                        productPrice
                ));
            });
        });
    }
}
