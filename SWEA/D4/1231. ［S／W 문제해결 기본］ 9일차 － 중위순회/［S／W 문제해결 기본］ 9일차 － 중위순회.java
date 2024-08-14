import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T = 10;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int tc =1;tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N+1];//0번 인덱스 안씀
			for(int i =1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				char ch = st.nextToken().charAt(0);
				tree[num] = ch;
				
			}
			System.out.printf("#%d ",tc);
			inorder(tree, 1, N);
			System.out.println();
		}
		
	}
	
	public static void inorder(char[] tree, int root, int N) {
		if(root*2 <= N) 
			inorder(tree, root*2, N);
		System.out.print(tree[root]);
		if(root*2+1 <= N) 
			inorder(tree, root*2+1, N);
	}
}