import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {

        String filePath =
                "C:\\Users\\Steliyan.sabchev\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\image.jpg";

        ZipOutputStream zipOutputStream = new ZipOutputStream(
                new FileOutputStream("zip.zip"));

        FileInputStream fileInputStream = new FileInputStream(filePath);

        zipOutputStream.putNextEntry(new ZipEntry(filePath));

        zipOutputStream.write(fileInputStream.readAllBytes());

        zipOutputStream.close();

    }
}
