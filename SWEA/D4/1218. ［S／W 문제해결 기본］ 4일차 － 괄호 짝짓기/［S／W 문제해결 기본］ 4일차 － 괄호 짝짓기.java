import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    static int T = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= T; tc++) {
            int length = Integer.parseInt(br.readLine());
            String input = br.readLine();

            int isValid = check(input) ? 1 : 0;
            System.out.println("#" + tc + " " + isValid);
        }
    }

    private static boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        
        // 열린 괄호와 닫힌 괄호의 매핑
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
        bracketMap.put('<', '>');

        for (char bracket : input.toCharArray()) {
            if (bracketMap.containsKey(bracket)) {
                stack.push(bracket); // 열린 괄호는 스택에 푸시
            } else if (bracketMap.containsValue(bracket)) {
                if (stack.isEmpty() || bracketMap.get(stack.pop()) != bracket) {
                    return false; // 스택이 비어있거나 짝이 맞지 않으면 false
                }
            }
        }
        
        return stack.isEmpty(); // 스택이 비어있으면 유효함
    }
}