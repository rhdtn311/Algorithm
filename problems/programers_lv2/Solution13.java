package programers_lv2;

import java.util.Stack;

public class Solution13 {

    public static String solution(String p) {

        return change(p);
    }

    public static String change(String p) {

        if (p.length() == 0) {
            return "";
        }

        int index = balanceString(p);
        String u = p.substring(0, index + 1);
        String v = index >= p.length() ? "" : p.substring(index + 1);

        if (checkCorrectString(u)) {
            return u + change(v);
        } else {
            StringBuilder sb = new StringBuilder(u).deleteCharAt(0).deleteCharAt(u.length() - 2);
            String newU = reverse(sb.toString());

            StringBuilder newSb = new StringBuilder("(");
            newSb.append(change(v)).append(')').append(newU);

            return newSb.toString();
        }
    }

    static String reverse(String p) {
        StringBuilder sb = new StringBuilder();

        for (char c : p.toCharArray()) {
            sb.append(c == ')' ? '(' : ')');
        }

        return sb.toString();
    }

    static boolean checkCorrectString(String p) {
        Stack<Character> stack = new Stack<>();

        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static int balanceString(String p) {

        int index = -1;
        int count = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            index++;

            if (count == 0) {
                break;
            }
        }

        return index;
    }
}
