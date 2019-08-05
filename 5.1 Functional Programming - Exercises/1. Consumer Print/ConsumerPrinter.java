import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrinter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        Consumer<String> print = System.out::println;

        Arrays.stream(reader.readLine().split("\\s+")).forEach(print);

    }
}
