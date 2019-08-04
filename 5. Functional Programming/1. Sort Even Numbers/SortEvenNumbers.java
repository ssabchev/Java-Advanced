import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] stringNumbers = reader.readLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        
        String evenNums = String.join(", ", evenNumbers.toString());
        System.out.println(evenNums.replaceAll("\\[|\\]", ""));

        evenNumbers.sort(Integer::compareTo);

       List<Integer> sorted = evenNumbers.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(sorted.toString().replaceAll("\\[|\\]", ""));




    }
}
