import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int i = 0; i < rows * 2; i++) {
            String[] elements = reader.readLine().split("\\s+");
            for (int j = 0; j < elements.length; j++) {
                if (i < rows) {
                    firstMatrix[i][j] = elements[j].charAt(0);
                } else {
                    secondMatrix[i - rows][j] = elements[j].charAt(0);
                }
            }
        }

        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];

                if (firstElement != secondElement) {
                    resultMatrix[row][col] = '*';
                } else {
                    resultMatrix[row][col] = firstElement;
                }
            }
        }

        for (char[] matrix : resultMatrix) {
            System.out.println(Arrays.toString(matrix)
                    .replaceAll("\\[|\\]|,", ""));
        }

    }
}
