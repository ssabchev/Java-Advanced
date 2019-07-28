import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String input;

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationCounter =
                new LinkedHashMap();

        while (!"report".equals(input = reader.readLine())) {

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!populationCounter.containsKey(country)) {
                populationCounter.put(country,
                        new LinkedHashMap<>() {{
                            put(city, population);
                        }}
                );
            } else {
                populationCounter.get(country).putIfAbsent(city, population);
            }
        }

        populationCounter.entrySet().stream().sorted((f, s) -> {

            Long firstPopulation = populationCounter.get(f.getKey())
                    .entrySet()
                    .stream()
                    .mapToLong(entry -> entry.getValue())
                    .sum();

            Long secondPopulation = populationCounter.get(s.getKey())
                    .entrySet()
                    .stream()
                    .mapToLong(entry -> entry.getValue())
                    .sum();

            return secondPopulation.compareTo(firstPopulation);
        }).forEach(entry -> {

            long totalPopulation = entry.getValue().values()
                    .stream()
                    .mapToLong(value -> value)
                    .sum();

            System.out.println(String.format("%s (total population: %d)",
                    entry.getKey(),
                    totalPopulation
            ));

            entry.getValue().entrySet()
                    .stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("=>%s: %d",
                                e.getKey(),
                                e.getValue()
                        ));
                    });
        });
    }
}
