package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        outer : for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();

            for (char c : br.readLine().toCharArray()) {
                if (c == '(') {
                    stack.push(0);
                } else {
                    if (stack.size() == 0) {
                        System.out.println("NO");
                        continue outer;
                    } else {
                        stack.pop();
                    }
                }
            }
            String result = stack.size() == 0 ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
