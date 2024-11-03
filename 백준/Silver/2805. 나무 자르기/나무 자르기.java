import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//[BOJ]2805.나무자르기
	
	static int N,M,left,right,mid;
	static int[] arr;
	static long tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		left = 0;
		right = -1;
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		while(left <= right) {
			mid = (left+right)/2;
			tree =0;
			
			for(int i=0; i<N; i++) {
				if(arr[i]>mid) {
					tree += arr[i] -mid;
				}
			}
			
			if(tree>=M) {
				left = mid+1;
			}else if(tree<M) {
				right=mid-1;
			}
		}
		
		System.out.println(right);
	}
}