import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;


public class FilterByAge {

    public static void main(String[] args) throws IOException {
        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
                (personAge, ageLimit) -> personAge.getValue() < ageLimit;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (personAge, ageLimit) -> personAge.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAndAge =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int peopleCount = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] personData = reader.readLine().split(",\\s+");

            people.put(personData[0], Integer.parseInt(personData[1]));
        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String printType = reader.readLine();


        people.entrySet().stream()
                .filter(person ->
                        condition.equals("younger") ?
                                youngerThan.test(person, ageLimit) :
                                olderThan.test(person, ageLimit)
                )
                .forEach(person -> {
                    if (printType.equals("age")) {
                        printAge.accept(person);
                    } else if (printType.equals("name")) {
                        printName.accept(person);
                    } else {
                        printNameAndAge.accept(person);
                    }
                });
    }
}
