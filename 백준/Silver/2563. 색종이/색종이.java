import java.util.Scanner;

interface Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), xst_point, yst_point, area = 0;
        boolean[][] arr = new boolean[100][100];

        for(int i=0; i<N; i++) {
            xst_point = sc.nextInt();
            yst_point = sc.nextInt();
            for(int x=xst_point; x<xst_point+10; x++) {
                for(int y=yst_point; y<yst_point+10; y++) {
                    if(!arr[y][x]) {
                        area++;
                        arr[y][x] = true;
                    }                    
                }
             }
        }
        System.out.println(area);
    }
}