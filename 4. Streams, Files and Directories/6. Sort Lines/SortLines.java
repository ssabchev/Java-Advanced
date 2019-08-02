import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


public class SortLines {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");

        Path pathIn = Paths.get(userDir + "/res/input.txt");
        Path pathOut = Paths.get(userDir + "/res/output.txt");

        List<String> inputLines = Files.readAllLines(pathIn);

        Collections.sort(inputLines);

        Files.write(pathOut, inputLines);

    }
}
