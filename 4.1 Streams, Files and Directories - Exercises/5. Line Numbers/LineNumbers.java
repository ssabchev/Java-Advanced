import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath));
              PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            int lineCount = 1;

            while (line != null) {
                writer.write(String.format("%d. %s%n",lineCount , line));
                lineCount++;

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
