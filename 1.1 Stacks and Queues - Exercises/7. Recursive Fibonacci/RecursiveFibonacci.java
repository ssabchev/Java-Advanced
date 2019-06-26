import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(reader.readLine());

        int result = getFibb(n);
        System.out.println(result);
    }

    private static int getFibb(int n) {
        if (n < 2) {
            return 1;
        }
        return getFibb(n - 1) + getFibb(n - 2);
    }
}
