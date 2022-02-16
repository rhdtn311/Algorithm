package programers_lv2;

import java.util.Stack;

public class Solution52 {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == '(') {
                if (stack.peek() == ')') {
                    return false;
                }
                stack.push(c);

            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
