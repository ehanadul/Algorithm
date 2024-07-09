import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int r = 2;
        for (int i = 1; i <= n; i++) {
            r = (r-1) + r;
        }
        System.out.println(r*r);
    }
}