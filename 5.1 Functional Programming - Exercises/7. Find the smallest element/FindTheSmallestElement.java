import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int smallestElement = Integer.MAX_VALUE;
        int possition = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= smallestElement) {
                smallestElement = numbers[i];
                possition = i;
            }
        }

        System.out.println(possition);

    }
}
