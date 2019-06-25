import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int comandsInput = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < comandsInput; i++) {
            int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int option = data[0];
            switch (option) {
                case 1:
                    numbers.push(data[1]);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(numbers));
                    break;
                default:
                    break;
            }
        }
    }
}
