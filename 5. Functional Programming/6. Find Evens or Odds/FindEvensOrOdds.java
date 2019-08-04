import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {

        Predicate<Integer> filterEven = x -> x % 2 == 0;
        Predicate<Integer> filterOdd = x -> x % 2 != 0;

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] data = reader.readLine().split(" ");
        String command = reader.readLine();

        int lowerBound = Integer.parseInt(data[0]);
        int upperBound = Integer.parseInt(data[1]);

        Predicate<Integer> byType = filterEven;

        if (command.equals("odd")) {
            byType = filterOdd;
        }

        IntStream
                .rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(byType)
                .forEach(element -> System.out.print(element + " "));
    }
}
