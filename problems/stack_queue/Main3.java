package stack_queue;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char before = ' ';
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            if (c == '(') {
                stack.push(c);
                sum++;
            } else {
                if (before == '(') {
                    sum--;
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                }
            }

            before = c;
        }

        System.out.println(sum);
    }
}
