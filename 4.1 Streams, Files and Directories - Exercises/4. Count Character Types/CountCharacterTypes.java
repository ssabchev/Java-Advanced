import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class CountCharacterTypes {
    public static void main(String[] args) {
        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        int[] countData = new int[3];

        try (PrintWriter writer = new PrintWriter(outputPath)) {
            String text = Files.readString(Path.of(filePath)).replaceAll("\r\n", " ");

            String vowels = "aeiou";
            String punctuation = "!,.?";

            for (char symbol : text.toCharArray()) {

                if (vowels.contains(symbol + "")){
                    countData[0]++;
                } else if (punctuation.contains(symbol + "")) {
                    countData[2]++;
                } else if (symbol != ' ') {
                    countData[1]++;
                }
            }

            writer.printf("Vowels: %d%n" +
                            "Consonants: %d%n" +
                            "Punctuation: %d%n",
                    countData[0],
                    countData[1],
                    countData[2]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
