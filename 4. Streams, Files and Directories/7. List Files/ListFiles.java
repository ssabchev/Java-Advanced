import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File f = new File("D:\\GIt projects\\Java-Advanced\\4. Streams, Files and Directories\\0. Tasks\\Resources");

        File[] allFiles = f.listFiles();

        if (allFiles == null){
            return;
        }

        for (File f1 : allFiles) {
            if (!f1.isDirectory()) {
                System.out.println(String.format("%s: [%d]",
                        f1.getName(),
                        f1.length()));
            }
        }
    }
}
