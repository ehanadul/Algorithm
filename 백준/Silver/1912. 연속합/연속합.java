import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    
    static int N,result;
    static int[] arr,dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		dp[0] = arr[0];

		result = dp[0];
		for (int i = 1; i < N; i++) {
			// (이전까지의 합 + 현재 합)과 현재 합 중에 더 큰 값을 dp에 할당한다.
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			result = Math.max(result, dp[i]);
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}