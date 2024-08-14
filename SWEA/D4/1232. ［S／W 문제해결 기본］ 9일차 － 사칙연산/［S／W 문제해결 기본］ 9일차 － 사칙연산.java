import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        boolean isOp;
        String op;
        int nodeNum;
        int leftNum;
        int rightNum;

        public Node(int nodeNum) {
            this.isOp = false;
            this.nodeNum = nodeNum;
        }

        public Node(boolean isOp, String op, int leftNum, int rightNum) {
            this.isOp = isOp;
            this.op = op;
            this.leftNum = leftNum;
            this.rightNum = rightNum;
        }
    }

    static int T = 10;
    static Map<Integer, Node> map; // map을 static으로 선언하여 전역에서 접근 가능하게 함

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            map = new HashMap<>(); // 각 테스트 케이스마다 새로운 맵 생성

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int nodeNum = Integer.parseInt(st.nextToken());
                String token = st.nextToken();

                if (operator(token)) { // 연산자인 경우
                    Node childNode = new Node(true, token, 0, 0);
                    childNode.leftNum = Integer.parseInt(st.nextToken());
                    childNode.rightNum = Integer.parseInt(st.nextToken());
                    
//                    System.out.println(childNode.leftNum+", "+childNode.rightNum);
                    map.put(nodeNum, childNode);
                } else { // 숫자인 경우
                    map.put(nodeNum, new Node(Integer.parseInt(token))); // 숫자 노드 생성
                }
            }
            sb.append("#").append(tc).append(" ").append(inorder(1)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int inorder(int i) {
        Node inorderNode = map.get(i);
        if (inorderNode.isOp) {
            return calculation(inorderNode.op, inorderNode.leftNum, inorderNode.rightNum);
        }
        return inorderNode.nodeNum;
    }

    private static boolean operator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int calculation(String op, int left, int right) {
        switch (op) {
            case "+":
                return inorder(left) + inorder(right);
            case "-":
                return inorder(left) - inorder(right);
            case "*":
                return inorder(left) * inorder(right);
            case "/":
//                if (inorder(right) == 0) {
//                    throw new ArithmeticException("Cannot divide by zero 영으로 나눌수 없어요 right="+right);
//                }
                return inorder(left) / inorder(right);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

}