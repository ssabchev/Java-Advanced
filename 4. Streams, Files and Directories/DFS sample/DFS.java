import java.io.File;

public class DFS {
    public static void main(String[] args) {

        File f = new File("D:\\GIt projects\\Java-Advanced\\4. Streams, Files and Directories\\0. Tasks\\Resources\\Files-and-Streams");

        DFS(f);

    }
    static void DFS (File root) {

        if (root == null) return;

        File[] files = root.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()){
                System.out.println("Dir:" + file.getName());
                DFS(file);
            } else {
                System.out.println(file.getName());
            }
        }

    }
}
