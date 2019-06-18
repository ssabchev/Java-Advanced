import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input = reader.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if ('(' == symbol) {
                stack.push(i);
            } else if (')' == symbol) {
                System.out.println(input.substring(stack.pop(), i + 1));
            }
        }
    }
}
