import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Scanner scanner = new Scanner(System.in);

        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath));
                PrintWriter printer = new PrintWriter(outputPath)) {

            Map<String , Integer> wordCount = new LinkedHashMap<>();

            String[] data = scanner.nextLine().split("\\s+");
            for (String words : data) {
                if (!wordCount.containsKey(words)){
                    wordCount.put(words, 0);
                }
            }

            String line = reader.readLine();

            while (line != null) {

                String[] elements = line.split("\\s+");

                for (String element : elements) {
                    if (wordCount.containsKey(element)){
                        wordCount.put(element, wordCount.get(element) + 1);
                    }
                }
                line = reader.readLine();
            }

            wordCount.entrySet().forEach(entry -> {
                printer.write(String.format("%s - %d",
                        entry.getKey(),
                        entry.getValue()
                ));
                printer.write(System.lineSeparator());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
