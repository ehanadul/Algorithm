import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// [BOJ] 9095. 1,2,3 더하기
	
	static int T,n;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			dp=new int[11];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i =4; i<=10;i++) {
				dp[i]= dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			
			T=Integer.parseInt(br.readLine());
			
			for(int t=0;t<T;t++) {
				n=Integer.parseInt(br.readLine());
				System.out.println(dp[n]);
			
		}
		
		
	}
}