import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int pushCount = data[0];
        int countToRemove = data[1];
        int numberToMatch = data[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).limit(pushCount)
                .forEach(e -> stack.push(Integer.parseInt(e)));

        for (int i = 0; i < countToRemove; i++) {
            stack.pop();
        }

        if (stack.contains(numberToMatch)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
