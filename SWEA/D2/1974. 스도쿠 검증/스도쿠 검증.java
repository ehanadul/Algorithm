import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int[][] sudoku = new int[9][9];
        int T = sc.nextInt(); 
         
        for (int test_case = 1; test_case <= T; test_case++) {
             
            boolean isValid = true;
 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
             
            // 중복 검사
            Set<Integer>[] row = new HashSet[9];
            Set<Integer>[] col = new HashSet[9];
            Set<Integer>[] box = new HashSet[9];
             
            // 초기화
            for (int i = 0; i < 9; i++) {
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
                box[i] = new HashSet<>();
            }
             
            outerLoop: for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int num = sudoku[i][j];
                     
                    if (row[i].contains(num) || col[j].contains(num) || box[(i/3)*3 + j/3].contains(num)) {
                        isValid = false;
                        break outerLoop;
                    }
                     
                    row[i].add(num);
                    col[j].add(num);
                    box[(i/3)*3 + j/3].add(num);
                }
            }
 
            if (isValid) {
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}