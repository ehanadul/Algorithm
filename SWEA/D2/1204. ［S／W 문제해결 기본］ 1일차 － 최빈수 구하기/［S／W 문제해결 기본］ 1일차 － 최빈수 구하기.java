import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int testNumber = Integer.parseInt(br.readLine());
            int[] frequency = new int[101]; 
            
            
            String[] scores = br.readLine().split(" ");
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(scores[i]);
                frequency[score]++;
            }
            
            int mode = 0; 
            int maxFrequency = frequency[0]; 
            

            for (int score = 1; score <= 100; score++) {
                if (frequency[score] > maxFrequency || 
                    (frequency[score] == maxFrequency && score > mode)) {
                    maxFrequency = frequency[score];
                    mode = score;
                }
            }
            
       
            System.out.println("#" + testNumber + " " + mode);    
        }
    }
}