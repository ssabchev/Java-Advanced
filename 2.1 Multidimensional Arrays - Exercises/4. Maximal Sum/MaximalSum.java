import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));
        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int maxSum = -1;
        int rowIndex = -1;
        int colIndex = -1;

        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = data[col];
            }
        }

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currnetSum = getmatrixSum(matrix, row, col);
                if (currnetSum > maxSum) {
                    maxSum = currnetSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrixByGivenCell(matrix, rowIndex, colIndex);

    }
    private static void printMatrixByGivenCell(int[][] matrix, int rowIndex, int colIndex) {
        if (rowIndex == -1 || colIndex == -1) {
            System.out.println("result not found!");
        } else {
            int beginRow = rowIndex - 1;
            int beginCol = colIndex - 1;

            for (int r = beginRow; r < beginRow + 3; r++) {
                for (int c = beginCol; c < beginCol + 3; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int getmatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row - 1][col + 1];

        return sum;
    }
}
