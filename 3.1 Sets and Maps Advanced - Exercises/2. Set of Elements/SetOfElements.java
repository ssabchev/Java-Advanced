import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] tokens = reader.readLine().split("\\s+");
        int firstSet = Integer.parseInt(tokens[0]);
        int secondSet = Integer.parseInt(tokens[1]);

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();

        while (firstSet-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            firstNumbers.add(number);
        }

        while (secondSet-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            secondNumbers.add(number);
        }

        firstNumbers.retainAll(secondNumbers);

        for (Integer number : firstNumbers) {
            System.out.print(number + " ");
        }
    }
}
