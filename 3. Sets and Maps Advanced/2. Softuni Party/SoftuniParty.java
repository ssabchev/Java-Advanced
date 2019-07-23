import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        Set<String> vipGuest = new TreeSet<>();
        Set<String> regularGuest = new TreeSet<>();

        String input = "";

        while (!"party".equalsIgnoreCase(input = reader.readLine())) {

            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vipGuest.add(input);
                } else {
                    regularGuest.add(input);
                }
            }
        }

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            if (Character.isDigit(input.charAt(0))) {
                vipGuest.remove(input);
            } else {
                regularGuest.remove(input);
            }
        }

        System.out.println(vipGuest.size() + regularGuest.size());
        for (String vip : vipGuest) {
            System.out.println(vip);
        }

        regularGuest.forEach(System.out::println);

    }
}
