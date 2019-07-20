import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {

    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int maxSum = -1;
        int rowIndex = -1;
        int colIndex = -1;

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currnetSum = getmatrixSum(row, col);
                if (currnetSum > maxSum) {
                    maxSum = currnetSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrixByGivenCell(rowIndex, colIndex);

    }

    private static void printMatrixByGivenCell(int rowIndex, int colIndex) {
        if (rowIndex == -1 || colIndex == -1) {
            System.out.println("result not found!");
        } else {
            int beginRow = rowIndex - 1;
            int beginCol = colIndex - 1;

            for (int r = beginRow; r < 3; r++) {
                for (int c = beginCol; c < 3; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int getmatrixSum(int row, int col) {
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

//    public static int returnMatrixSum (int[][] matrix) {
//        int sum = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                sum += matrix[row][col];
//            }
//        }
//        return sum;
//    }
}
