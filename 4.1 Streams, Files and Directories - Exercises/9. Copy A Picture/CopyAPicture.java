import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {


        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\image.jpg";


        FileInputStream inputStream = new FileInputStream(filePath);

        byte[] image = inputStream.readAllBytes();

        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");

        fileOutputStream.write(image);

        fileOutputStream.close();

    }
}
