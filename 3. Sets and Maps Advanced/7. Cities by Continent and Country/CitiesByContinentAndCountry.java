import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int count = Integer.parseInt(reader.readLine());

        Map<String, Map<String, ArrayList<String>>> citiesByContinentsAndCountries =
                new LinkedHashMap<>();



        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            citiesByContinentsAndCountries.putIfAbsent(continent , new LinkedHashMap<>());
            citiesByContinentsAndCountries.get(continent).putIfAbsent(country, new ArrayList<>());
            citiesByContinentsAndCountries.get(continent).get(country).add(city);

        }

        citiesByContinentsAndCountries.forEach((continent, country) -> {
            System.out.println(continent + ":");
            country.forEach((countryName, city) -> {
                String cityNames = city.toString().replaceAll("\\[|\\]", "");
                System.out.println(String.format(
                        "%s -> %s",
                        countryName,
                        cityNames
                ));
            });
        });

    }
}


