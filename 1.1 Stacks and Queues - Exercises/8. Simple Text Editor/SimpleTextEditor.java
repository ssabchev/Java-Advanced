import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        int commandsCount = Integer.parseInt(reader.readLine());

        List<Character> data = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] input = reader.readLine().split("\\s+");
            String cmd = input[0];

            switch (cmd) {
                case "1":
                    for (int j = 0; j < input[1].length(); j++) {
                        data.add(input[1].charAt(i));
                    }
                    data.add(input[1].split(""));
                    break;
                case "2":
                    int countToErase = Integer.parseInt(input[1]);
                    break;
                case "3":
                    int indexToPrint = Integer.parseInt(input[1]);
                    System.out.println(data.get(indexToPrint - 1));
                    break;
                case "4" :

                    break;
                default:
                    break;
            }


        }

    }
}
