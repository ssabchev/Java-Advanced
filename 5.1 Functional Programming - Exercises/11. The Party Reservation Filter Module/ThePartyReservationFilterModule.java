import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        String[] names = reader.readLine().split("\\s+");

        String command = "";

        HashMap <String, Predicate<String>> predicates = new HashMap<>();

        while (!"Print".equals(command = reader.readLine())) {

            String[] tokens = command.split(";");

            String type = tokens[1];
            String criteria = tokens[2];

            String filterName = type + criteria;

            if (tokens[0].contains("Add")) {

                Predicate<String>  predicate;

                if (type.contains("Starts")) {
                    predicate = str -> str.startsWith(criteria);
                } else if (type.contains("Ends")) {
                    predicate = str -> str.endsWith(criteria);
                } else if (type.contains("Lenght")) {
                    predicate = str -> str.length() == Integer.parseInt(criteria);
                } else {
                    predicate = str -> str.contains(criteria);
                }

                predicates.putIfAbsent(filterName, predicate);

            } else {
                predicates.remove(filterName);

            }

        }

        Arrays.stream(names).forEach(name -> {
            boolean[] hasToBeFiltered = new boolean[1];
            predicates.forEach((k, v) -> {
               if (v.test(name)){
                   hasToBeFiltered[0] = true;
               }
            });
            if (!hasToBeFiltered[0]) {
                System.out.print(name + " ");
            }
        });
    }
}
