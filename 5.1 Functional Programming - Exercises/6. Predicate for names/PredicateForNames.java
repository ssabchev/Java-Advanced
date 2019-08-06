import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        int lenght = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split("\\s+");

        Predicate<String> isPrintable = str -> {
          boolean canPrint = false;
          if (str.length() <= lenght) {
              canPrint = true;
          }
            return canPrint;
        };

        for (String name : names) {
            if (isPrintable.test(name)) {
                System.out.println(name);
            }
        }

    }
}
