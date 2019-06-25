import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        ArrayDeque<String> stack = new ArrayDeque<>();

//          Another way to solve the task.
//        String[] input = reader.readLine().split(" ");
//
//        for (int i = 0; i < input.length; i++) {
//            stack.push(input[i]);
//        }

        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(e -> stack.push(e));

        while (stack.size() != 0) {
            if (stack.size() == 1) {
                System.out.print(stack.pop());
            } else {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}
