import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input = reader.readLine();

        TreeMap<Character , Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol , 1);
            } else {
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> keyValuePair : symbolsCount.entrySet()) {
            System.out.println(String.format("%c: %d time/s",
                    keyValuePair.getKey(),
                    keyValuePair.getValue()
                    ));
        }

    }
}
