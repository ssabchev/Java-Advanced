import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in));

        int[] dim = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[][] matrix = new int[dim[0]][dim[1]];

        for (int row = 0; row < matrix.length; row++) {
            String[] line = reader.readLine().split("\\s+");
            
            for (int col = 0; col < line.length; col++) {
            int value = Integer.parseInt(line[col]);

            matrix[row][col] = value;
            }
        }
        
        int searchNumber = Integer.parseInt(reader.readLine());
        boolean isFound = true;

        for (int row = 0; row < matrix.length; row++) {
            int[] ints = matrix[row];
            for (int col = 0; col < ints.length; col++) {
                int value = ints[col];
                if (value == searchNumber) {
                    isFound = false;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (isFound){
            System.out.println("not found");
        }
    }
}
