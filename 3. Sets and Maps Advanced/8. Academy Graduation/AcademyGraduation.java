import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int count = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> studentAndGrades = new TreeMap<>();

        while (!(count-- == 0)) {
            String name = reader.readLine();
            List<Double> grades = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            studentAndGrades.putIfAbsent(name, new ArrayList<>());
            studentAndGrades.get(name).addAll(grades);
        }


        studentAndGrades.forEach((name, grades) -> {
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            double avg = sum / grades.size();
            System.out.println(String.format(
                    "%s is graduated with %s",
                    name,
                    avg
            ));
        });
    }
}
