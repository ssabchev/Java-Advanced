import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));


        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int matrixRows = input[0];
        int matrixCols = input[1];

        String[][] matrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrix.length; row++) {
            String[] data = reader.readLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = data[col];
            }
        }

        String inputLine = "";

        while (!"END".equals(inputLine = reader.readLine())) {
            String[] data = inputLine.split("\\s+");


            if (data.length != 5 || !data[0].equals("swap")){
                System.out.println("Invalid input!");
                continue;
            } else {
                String command = data[0];
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);
                if (row1 < 0 || row1 > matrixRows || col1 < 0 || col1 > matrixCols
                        || row2 < 0 || row2 > matrixRows || col2 < 0 || col2 > matrixCols
                ) {
                    System.out.println("Invalid input!");
                } else {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);
                }
            }
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
