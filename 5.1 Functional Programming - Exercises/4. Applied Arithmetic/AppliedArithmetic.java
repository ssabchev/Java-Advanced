import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        String command = reader.readLine();

        Consumer<ArrayList<Integer>> printer =
                arr -> arr.forEach(num -> System.out.print(num + " "));

        Function<ArrayList<Integer>, ArrayList<Integer>> increment = list -> list.stream()
                .map(e -> ++e)
                .collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> byTwo = list -> list.stream()
                .map(e -> e *= 2)
                .collect(Collectors.toCollection(ArrayList::new));

        UnaryOperator<ArrayList<Integer>> minusOne = list -> list.stream()
                .map(e -> e -= 1)
                .collect(Collectors.toCollection(ArrayList::new));

        while (!"end".equals(command)) {

            switch (command) {
                case "add":
                    numbers = increment.apply(numbers);
                    break;
                case "multiply":
                    numbers = byTwo.apply(numbers);
                    break;
                case "substact":
                    numbers = minusOne.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    break;
            }
            command = reader.readLine();
        }
    }
}
