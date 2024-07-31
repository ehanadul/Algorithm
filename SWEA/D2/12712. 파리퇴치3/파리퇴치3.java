import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int max = 0; 

            int arr[][] = new int[2 * N][2 * N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i + N][j + N] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = N; i < 2 * N; i++) {
                for (int j = N; j < 2 * N; j++) {
                    int sum = 0;

                    for (int k = -M + 1; k <= M - 1; k++) {
                        if (j + k >= 0 && j + k < 2 * N) {
                            sum += arr[i][j + k]; // 가로
                        }
                        if (i + k >= 0 && i + k < 2 * N) {
                            sum += arr[i + k][j]; // 세로
                        }
                    }
                    sum -= arr[i][j];
                    max = Math.max(max, sum);

                    sum = 0; 
                    for (int k = -M + 1; k <= M - 1; k++) {
                        if (i + k >= 0 && i + k < 2 * N && j + k >= 0 && j + k < 2 * N) {
                            sum += arr[i + k][j + k]; // \ 대각선
                        }
                        if (i - k >= 0 && i - k < 2 * N && j + k >= 0 && j + k < 2 * N) {
                            sum += arr[i - k][j + k]; // / 대각선
                        }
                    }
                    sum -= arr[i][j]; 
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}