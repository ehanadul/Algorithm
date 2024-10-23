import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {
	//[BOJ]5052.전화번호 목록
	
    static int t,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  =new StringBuilder();
        
        t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            String [] number = new String[n];
 
            for(int j=0; j<n; j++){
                number[j] = br.readLine();
                map.put(number[j],0);
            }
 
            Arrays.sort(number);
 
            boolean flag = true;
 
            for(int j=1; j<n; j++){
                for(int k=1; k<number[j].length(); k++){
                    if(map.containsKey(number[j].substring(0,k))){
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
            }
            if(flag){
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}