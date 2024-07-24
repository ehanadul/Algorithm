import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Double> st = new Stack<Double>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Double[] arr = new Double[N];
		String str = br.readLine();
		
		for(int i=0; i<N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		postfix(arr,str);
		System.out.println(String.format("%.2f", st.pop()));
	}
	
	
	public static void postfix(Double[] arr, String str) {
		int idx = 0;
		
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
		
			if('A'<=temp && temp<='Z') {
				idx = temp - 'A';
				st.add(arr[idx]);
			}else {	
				double valueB = st.pop();
				double valueA = st.pop();
				double result = cal(valueA, valueB, temp); 
				st.add(result);
			}
		}
	}
	
	public static double cal(double A, double B, char temp) {
		double value = 0;
		switch (temp) {
		case '+':
			value = A+B;
			break;
		case '-':
			value = A-B;
			break;
		case '/':
			value = A/B;
			break;
		case '*':
			value = A*B;
			break;
		}
		return value;
	}
}