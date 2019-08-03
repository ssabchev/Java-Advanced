import java.io.*;
import java.math.BigInteger;

public class AllCapitals {
    public static void main(String[] args) {
        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(outputPath)
        ) {

            String line = reader.readLine();

            while (line != null) {

                writer.write(line.toUpperCase());
                writer.write(System.lineSeparator());
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
