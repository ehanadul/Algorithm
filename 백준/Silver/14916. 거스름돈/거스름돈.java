import java.util.Scanner;

public class Main {
	//[BOJ]14916.거스름돈
	
	static int N;
	static int[] dp;
	static int[] coin = {2,5};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new int[N+1];
		
		dp[0] = 0;
		for(int i =1; i<=N;i++) {
			dp[i] = Integer.MAX_VALUE;
		}//초기화
		
		for(int c : coin) {
			for(int i =c; i<=N;i++) {
				if(dp[i-c] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i-c]+1);
				}	
			}
		}
		
		if(dp[N] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}