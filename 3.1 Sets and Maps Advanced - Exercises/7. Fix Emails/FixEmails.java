import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        Map<String, String> usersAndEmails = new LinkedHashMap<>();

        String name;

        while (!"stop".equals(name = reader.readLine())) {
            String email = reader.readLine();

            if (!email.endsWith("us") && !email.endsWith("com") && !email.endsWith("uk")) {
                usersAndEmails.putIfAbsent(name, email);
            }
        }

        for (Map.Entry<String, String> entry : usersAndEmails.entrySet()) {
            System.out.println(String.format("%s -> %s",
                    entry.getKey(),
                    entry.getValue()
            ));
        }
    }
}
