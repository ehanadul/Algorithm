import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N <= 9 && N >= 1) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(N + " * " + i + " = " + (N * i));
            }
        }
    }
}

