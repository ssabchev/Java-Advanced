import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int numbersToAdd = data[0];
        int numbersToRemove = data[1];
        int numberToContain = data[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int[] elements = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int i = 0;
        while (numbersToAdd-- > 0) {
            numbers.offer(elements[i++]);
        }

        while (numbersToRemove-- > 0) {
            numbers.poll();
        }

        if (numbers.isEmpty()) {
            System.out.println(0);
        } else if (numbers.contains(numberToContain)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbers));
        }
    }
}
