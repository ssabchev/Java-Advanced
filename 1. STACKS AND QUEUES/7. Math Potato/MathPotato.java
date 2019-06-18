import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        String[] data = reader.readLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, data);
        int n = Integer.parseInt(reader.readLine());

        int cycleCount = 0;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            cycleCount++;

            if (isPrime(cycleCount)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number == 1) {
            isPrime = false;
        } else if (number == 2 || number == 3) {
            isPrime = true;
        } else {
            if (number % 2 == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }



}
