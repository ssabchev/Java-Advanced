import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) {
        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        BigInteger totalSum = BigInteger.ZERO;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);


            String line = reader.readLine();

            while (line != null) {

                for (char symbol : line.toCharArray()) {
                  totalSum = totalSum.add(BigInteger.valueOf(symbol));
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(totalSum);
    }
}
