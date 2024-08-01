import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[SIZE][SIZE];

          
            for (int i = 0; i < SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = maxSum(arr);
            System.out.printf("#%d %d%n", t, max);
        }
    }

    static int maxSum(int[][] arr) {
        int max = 0;
        int diagonalSumA = 0;
        int diagonalSumB = 0;

        for (int i = 0; i < SIZE; i++) {
            int rowSum = 0;
            int columnSum = 0;

            for (int j = 0; j < SIZE; j++) {
                rowSum += arr[i][j];        // 행 
                columnSum += arr[j][i];     // 열 
            }

   
            max = Math.max(max, Math.max(rowSum, columnSum));

         
            diagonalSumA += arr[i][i];              //대각선a
            diagonalSumB += arr[i][SIZE - 1 - i];   //대각선b
        }

   
        max = Math.max(max, Math.max(diagonalSumA, diagonalSumB));

        return max;
    }
}