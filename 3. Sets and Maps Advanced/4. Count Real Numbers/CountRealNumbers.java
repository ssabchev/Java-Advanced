import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] input = reader.readLine().split("\\s+");

        Map<Double , Integer> result = new LinkedHashMap<>();

        for (String inputElement : input) {
            Double key = Double.parseDouble(inputElement);
            if (!result.containsKey(key)) {
                result.put(key , 0);
            }
            result.put(key, result.get(key) + 1);
        }

        for (Map.Entry<Double, Integer> kvp : result.entrySet()) {
            System.out.println(String.format("%.1f -> %s", kvp.getKey(), kvp.getValue()));
        }

    }
}
