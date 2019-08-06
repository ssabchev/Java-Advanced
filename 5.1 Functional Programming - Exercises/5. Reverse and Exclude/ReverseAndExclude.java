import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        int divisibleNumber = Integer.parseInt(reader.readLine());


        numbers = numbers.stream().filter(e -> e % divisibleNumber != 0)
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.sort(numbers, Collections.reverseOrder());

        numbers.forEach(e -> System.out.print(e + " "));


    }
}
