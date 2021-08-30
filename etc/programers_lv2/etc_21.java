package programers_lv2;

import java.util.*;

public class etc_21 {
    // 프로그래머스 lv 2 : 괄호 회전하기
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(s.length()-1) + s.substring(0, s.length()-1);
            boolean result = checkCorrect(s);
            System.out.println("s : " + s + "   result : " + result);
            if (result) answer++;
        }
        return answer;

    }

    public static boolean checkCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '{') {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
