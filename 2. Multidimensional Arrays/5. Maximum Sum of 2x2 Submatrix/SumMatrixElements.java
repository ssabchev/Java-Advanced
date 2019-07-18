import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        int[] data = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[data[0]][data[1]];
        
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(reader.readLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col];
            }
        }

        int[][] temp = new int[2][2];
        int[][] biggestMatrix = new int[2][2];

        for (int i = 0; i < data[0] - 1; i++) {
            for (int j = 0; j < data[1]; j++) {
                int count = 0;
                while (count != data[1] - 1) {
                    for (int row = 0; row < 2; row++) {
                        for (int col = 0; col < 2; col++) {
                            temp[row][col] = matrix[row + i][col + count];
                        }
                    }
                    if (returnSum(temp) > returnSum(biggestMatrix)){
                        for (int row = 0; row < 2; row++) {
                            for (int col = 0; col < 2; col++) {
                                biggestMatrix[row][col] = temp[row][col];
                            }
                        }
                    }
                    count++;
                }
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(returnSum(biggestMatrix));
        
        

    }
    public static int returnSum (int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
