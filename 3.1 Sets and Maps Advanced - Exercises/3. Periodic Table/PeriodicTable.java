import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int count = Integer.parseInt(reader.readLine());

        TreeSet<String> elements = new TreeSet<>();

        while (count-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            for (int i = 0; i < data.length; i++) {
                elements.add(data[i]);
            }
        }

        elements.forEach(element -> System.out.print(element + " "));

    }
}
