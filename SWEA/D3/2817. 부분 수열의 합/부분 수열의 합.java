import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static boolean[] sel;
	static int N, K;
	static int[] arr;
	static int count = 0;

	// 2817. 부분 수열의 합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim()); 
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); 
			K = Integer.parseInt(st.nextToken()); 
			
			sel = new boolean[N];
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			count = 0; 
			sumNumber(0);
			
			System.out.printf("#%d %d\n", tc, count); 
		}
		br.close();
	}
    
    public static void sumNumber(int idx) {
    	if (idx == N) {
    		int sum = 0;
    		for (int i = 0; i < N; i++) {
    			if (sel[i]) {
    				sum += arr[i];
    			}
    		}
			if (sum == K && sum > 0) {
				count++;
			}
			return;
    	}
    	
    	sel[idx] = true;
    	sumNumber(idx + 1);
    	
    	sel[idx] = false;
    	sumNumber(idx + 1);
    }
}