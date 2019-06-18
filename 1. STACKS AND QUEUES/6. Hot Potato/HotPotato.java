import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );


        String[] data = reader.readLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, data);
        int n = Integer.parseInt(reader.readLine());

        int cycleCount = 0;

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            count++;
            if (count )

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());



        int counter = 0;
        if (cycleCount / 1 = )


    }




}
