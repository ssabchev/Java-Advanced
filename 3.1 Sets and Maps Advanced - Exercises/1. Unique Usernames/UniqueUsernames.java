import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        Set<String> usernames = new LinkedHashSet<>();

        int count = Integer.parseInt(reader.readLine());

        String input;

        for (int i = 0; i < count; i++) {
            input = reader.readLine();

            if (!usernames.contains(input)) {
                usernames.add(input);
            }
        }

        for (String username : usernames) {
            System.out.println(username);
        }

    }
}
