import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        for(int tc =1; tc<=10;tc++) {
            int T = Integer.parseInt(br.readLine());
             
            String search = br.readLine();
            String str = br.readLine();
            int cnt=0;
         
            for(int i=0;i<str.length()-search.length()+1;i++) {
                if(str.substring(i, i+search.length()).equals(search)) {
                    cnt++;
                }
            }System.out.println("#"+ T + " " + cnt);
        }
    }
}