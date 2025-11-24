import java.io.BufferedReader;
import java.util.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean [][] array = new boolean[100][100];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                    int x= Integer.parseInt(st.nextToken());
                    int y= Integer.parseInt(st.nextToken());


                    for(int j=x;j<x+10;j++){
                        for(int k=y;k<y+10;k++){
                            array[j][k]= true;
                        }
                    }
            }

            int answer = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if(array[i][j]) answer++;
                }
            }

            System.out.println(answer);
        }

    }
