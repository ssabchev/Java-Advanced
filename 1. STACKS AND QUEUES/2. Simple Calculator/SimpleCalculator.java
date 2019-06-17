import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input = reader.readLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] elements = input.split("\\s+");

        for (int i = elements.length - 1; i >=0; i--) {
            stack.push(elements[i]);
        }


        while (stack.size() > 1) {
            Integer firstNum = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());

            if ("+".equalsIgnoreCase(operation)) {
               stack.push(firstNum + secondNum + "");
            } else {
                stack.push(firstNum - secondNum + "");
            }
        }
        System.out.println(stack.peek());
    }
}
