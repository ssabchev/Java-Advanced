import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int size = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[size][size];

        for (int rows = 0; rows < size; rows++) {
            int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < size; cols++) {
                matrix[rows][cols] = data[cols];
            }
        }

        System.out.println(Math.abs(primaryDiagonalSum(matrix) - secondaryDiagonalSum(matrix)));

    }

    public static int primaryDiagonalSum (int[][] matrix) {
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
               sum+= matrix[rows][rows];
        }
        return sum;
    }

    public static int secondaryDiagonalSum (int[][] matrix) {
        int sum = 0;
        int count = matrix.length - 1;
        for (int rows = 0; rows < matrix.length; rows++) {
            sum += matrix[rows][count];
            count--;
        }
        return sum;
    }
}
