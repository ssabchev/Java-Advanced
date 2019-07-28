import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );
        Map<String, String> phonebook = new HashMap<>();

        String input;


        while (!"search".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            phonebook.putIfAbsent(name, phoneNumber);
        }

        while (!"stop".equals(input = reader.readLine())) {
            if (phonebook.containsKey(input)) {
                System.out.println(String.format("%s -> %s",
                        input,
                        phonebook.get(input)
                ));
            } else {
                System.out.println(String.format("Contact %s does not exist.",
                        input
                ));
            }
        }
    }
}
