import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input = "";

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!"Home".equalsIgnoreCase(input = reader.readLine())) {
            if (!"back".equalsIgnoreCase(input)) {
                stack.push(input);
                System.out.println(input);
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
        }
    }
}
