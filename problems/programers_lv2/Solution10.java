package programers_lv2;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution10 {
    public static void main(String[] args) {
        System.out.println(solution("abbaccaa"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
