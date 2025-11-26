import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = new String(br.readLine());
        int i = 0;
        int count =0;
        while ( i < s.length()){
                    if(i+2 < s.length() && s.substring(i,i+3).equals("dz=")){

                        
                        count++;
                        i=i+3;
                    }
                    else if(i+1 < s.length()){
                            if(s.substring(i,i+2).equals("c=")
                            || s.substring(i,i+2).equals("c-")
                            || s.substring(i,i+2).equals("d-")
                            || s.substring(i,i+2).equals("lj")
                            || s.substring(i,i+2).equals("s=")
                            || s.substring(i,i+2).equals("nj")
                            || s.substring(i,i+2).equals("z=")){

                               
                                count++;
                                i=i+2;

                            }else {
                                count++;
                                i++;
                            }

                    }else {
                        count++;
                        i++;
                    }

        }
        System.out.println(count);

    }
}