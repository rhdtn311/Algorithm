package programers_lv2;

import java.util.Stack;

public class Solution33 {
    public static void main(String[] args) {
        String solution = solution("999", 2);
        System.out.println(solution);
    }

    public static String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {

            while (!stack.isEmpty() && stack.peek() < Character.getNumericValue(number.charAt(i)) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(Character.getNumericValue(number.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (int s : stack) {
            sb.append(s);
        }

        return sb.substring(0, sb.length() - k);
    }
}
