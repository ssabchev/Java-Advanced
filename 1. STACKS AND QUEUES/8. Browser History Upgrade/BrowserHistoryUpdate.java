import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistoryUpdate {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        String input = "";

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"Home".equalsIgnoreCase(input = reader.readLine())) {
            if ((!"back".equalsIgnoreCase(input)) && (!"forward".equalsIgnoreCase(input))) {
                stack.push(input);
                System.out.println(input);
                queue.clear();
            } else if (input.equalsIgnoreCase("back")){
                if (stack.size() > 1) {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equalsIgnoreCase("forward")) {
                if (queue.size() == 0) {
                    System.out.println("no next URLs");
                } else {
                    stack.push(queue.peek());
                    System.out.println(stack.peek());
                    queue.clear();
                }
            }
        }
    }
}
