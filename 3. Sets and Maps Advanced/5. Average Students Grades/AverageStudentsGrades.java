import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int count = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {

            String[] tokens = reader.readLine().split("\\s+");

            studentsAndGrades.putIfAbsent(tokens[0], new ArrayList<>());

            studentsAndGrades.get(tokens[0]).add(Double.parseDouble(tokens[1]));
        }

        studentsAndGrades.forEach((name, grades) -> {

            String allGrades = grades.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double avg = grades.stream().mapToDouble(e -> e).average().orElse(0d);

            System.out.println(String.format("%s -> %s (avg: %.2f)",
                    name,
                    allGrades,
                    avg
            ));
        });

    }
}
