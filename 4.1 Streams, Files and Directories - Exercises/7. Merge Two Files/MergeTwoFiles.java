import java.io.*;

public class MergeTwoFiles {

    public static void main(String[] args) throws IOException {

        String filePathOne =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String filePathTwo =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        String result =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";


        BufferedReader reader = new BufferedReader(new FileReader(filePathOne));
        BufferedReader readerTwo = new BufferedReader(new FileReader(filePathTwo));

        FileWriter printer = new FileWriter(result);

        String line = reader.readLine();
        while (line != null) {
            printer.write(line);
            printer.write(System.lineSeparator());
            line = reader.readLine();
        }

        String secondLine = readerTwo.readLine();
        while (secondLine != null) {
            printer.write(secondLine);
            printer.write(System.lineSeparator());
            secondLine = readerTwo.readLine();

        }

        printer.close();

    }

}
