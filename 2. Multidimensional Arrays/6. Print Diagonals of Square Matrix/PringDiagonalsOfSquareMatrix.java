import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PringDiagonalsOfSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int size = Integer.parseInt(reader.readLine());
        
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] data = reader.readLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = data[col];
            }
        }

        String firstDiagonal = "";
        String secondDiagonal = "";

        for (int i = 0; i < size; i++) {
            firstDiagonal += matrix[i][i] + " ";
        }
        int count = 0;
        for (int i = size - 1; i >= 0; i--) {
            secondDiagonal += matrix[i][count++] + " ";
        }


        System.out.println(firstDiagonal.trim());
        System.out.println(secondDiagonal.trim());
    }
}
