import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int firstMatrixSize = Integer.parseInt(reader.readLine());

        int[][] firstMatrix = new int[firstMatrixSize][];

        for (int row = 0; row < firstMatrixSize; row++) {
            String[] inputData = reader.readLine().split("\\s+");
            firstMatrix[row] = new int[inputData.length];

            for (int col = 0; col < inputData.length; col++) {
                int number = Integer.parseInt(inputData[col]);
                firstMatrix[row][col] = number;
            }
        }

        int secondMatrixSize = Integer.parseInt(reader.readLine());
        int[][] secondMatrix = new int[secondMatrixSize][];

        for (int row = 0; row < firstMatrixSize; row++) {
            String[] inputData = reader.readLine().split("\\s+");
            secondMatrix[row] = new int[inputData.length];

            for (int col = 0; col < inputData.length; col++) {
                int number = Integer.parseInt(inputData[col]);
                secondMatrix[row][col] = number;
            }
        }

        if (firstMatrixSize != secondMatrixSize) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            boolean areArraysNotEqual = firstMatrix[row].length != secondMatrix[row].length;
            if (areArraysNotEqual) {
                System.out.println("not equal");
                return;
            }

            for (int col = 0; col < firstMatrix.length; col++) {
                int firstValue = firstMatrix[row][col];
                int secondValue = firstMatrix[row][col];
                if (firstValue != secondValue) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");

    }
}
