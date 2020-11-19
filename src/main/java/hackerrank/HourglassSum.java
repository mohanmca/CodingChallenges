package hackerrank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HourglassSum {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int hourglassSum = -100;
        for (int row = 1; row < arr.length - 1; row++) {
            for (int col = 1; col < arr.length - 1; col++) {
                int top = arr[row - 1][col - 1] + arr[row - 1][col] + arr[row - 1][col + 1];
                int bottom = arr[row + 1][col - 1] + arr[row + 1][col] + arr[row + 1][col + 1];
                int currentHourglassSum = arr[row][col] + top + bottom;
                if (currentHourglassSum > hourglassSum) {
                    hourglassSum = currentHourglassSum;
                }
            }
        }
        return hourglassSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}