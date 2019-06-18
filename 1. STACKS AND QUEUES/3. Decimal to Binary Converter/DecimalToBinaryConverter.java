import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );


            int number = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        while (stack.size() != 0) {
            System.out.print(stack.pop());
        }

    }
}
