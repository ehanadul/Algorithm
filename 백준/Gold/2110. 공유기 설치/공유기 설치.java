import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//[BOJ]2110. 공유기 설치

	static int N,C;
	static int[] house;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		house = new int[N];
		
		
		
		for(int i =0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
//		System.out.println(Arrays.toString(house));
		
		
		int left = 1;
		int right = house[N-1] - house[0];
		int result = 0;
		int d =0;
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			int start = house[0];
			int count = 1;
			
			for(int i=0; i<N; i++) {
				
				d= house[i] - start;
				
				if(d>= mid) {
					count++;
					start = house[i];
				}
			}
			
			
			if(count >= C) {
				result = mid;
				
				left = mid +1; //간격 넓히기
			}else {
				right = mid -1;
			}
		}
		
		System.out.println(result);
		
		
		
		
	}


}