import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // 후위표기식 변환
    public static String change(String str) {
        Map<Character, Integer> isp = new HashMap<>();
        Map<Character, Integer> icp = new HashMap<>();
        isp.put('*', 2);
        isp.put('+', 1);
        icp.put('*', 2);
        icp.put('+', 1);

        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (Character.isDigit(curr)) { // 숫자일 때
                output.append(curr);
            } else if (icp.containsKey(curr)) { // 연산자일 때
                while (!stack.isEmpty() && (isp.get(stack.peek()) >= icp.get(curr))) {
                    output.append(stack.pop());
                }
                stack.push(curr);
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    // 후위표기식 계산
    public static int calculator(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '+' || curr == '*') { // 연산자일 때
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch (curr) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                }
            } else { // 피연산자일 때
                stack.push(Character.getNumericValue(curr));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int t = 1; t <= 10; t++) {
                br.readLine(); // 테스트 케이스 길이 안씀
                String tc = br.readLine();
                String postfix = change(tc);
                int result = calculator(postfix);
                System.out.printf("#%d %d\n", t, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}