package programers_lv2;

import java.util.Stack;

public class Solution27 {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (checkCorrect(sb.toString())) count++;

            sb.append(sb.charAt(0)).deleteCharAt(0);
            System.out.println(sb);
        }

        return count;

    }

    boolean checkCorrect(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') {
                    return false;
                }
                stack.push(c);
                continue;
            }

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
