import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int C = (B % 10) * A;
        int D = ((B % 100) / 10) * A;
        int E = (B /100) * A;
        int F = C + (D * 10) + (E * 100);

        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        scanner.close();
    }
}
