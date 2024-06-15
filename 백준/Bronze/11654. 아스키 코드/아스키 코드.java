import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int n = (int)str.charAt(0);
		sc.close();
		
		System.out.println(n);
	}

}