import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] parents;
    private static PriorityQueue<House> pq;

    private static class House implements Comparable<House>{
        int s, e, w;

        House(int s ,int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(House o) {
            if(this.w > o.w){
                return 1;
            }else if(this.w < o.w){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        pq = new PriorityQueue<>();
        parents = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            parents[i] =i;
        }

        for (int i = 0; i < m; i++) {
            stz= new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());

            pq.add(new House(a, b, c));
        }

        int cnt = n-1;
        int ans  = 0;
        int lastW = 0; // 제일 마지막에 추가되는 간선의 가중치

        while (cnt>0){
            House h = pq.poll();

            // 사이클이 생기지 않는다면
            if(union(h.s, h.e)){
                ans += h.w;
                cnt--;
            }

            if(cnt == 0) lastW = h.w; // 마지막 가중치 저장
        }

        // 마지막 가중치 제거 후 출력
        bw.write(String.valueOf(ans - lastW));

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;

        if(root1 < root2){
            parents[root1] = root2;
        }else{
            parents[root2] = root1;
        }
        return true;
    }

    private static int find(int a){
        if(parents[a] == a){
            return a;
        }
        return find(parents[a]);
    }
}