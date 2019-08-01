import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );
        
        Map<String, Integer> minerTask = new LinkedHashMap<>();

        String input;

        while (!"stop".equals(input = reader.readLine())) {
            int quantity = Integer.parseInt(reader.readLine());

            if (!minerTask.containsKey(input)) {
                minerTask.put(input, quantity);
            } else {
                minerTask.put(input, minerTask.get(input) + quantity);
            }
        }

        for (Map.Entry<String, Integer> keyAndValue : minerTask.entrySet()) {
            System.out.println(String.format("%s -> %s",
                    keyAndValue.getKey(),
                    keyAndValue.getValue()
            ));
        }

    }
}
