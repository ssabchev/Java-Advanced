import java.io.*;

public class SumLines {
    public static void main(String[] args) {

        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try  {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(filePath));

            String line = reader.readLine();

            while (line != null) {
                int asciiSum = 0;
                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }
                System.out.println(asciiSum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
