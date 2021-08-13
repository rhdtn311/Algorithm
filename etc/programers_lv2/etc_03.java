package programers_lv2;

import java.util.*;

public class etc_03 {
    // 프로그래머스 lv 2 : 짝지어 제거하기 (https://programmers.co.kr/learn/courses/30/lessons/12973)
    public int solution(String s) {

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        if (queue.size() % 2 == 1) return 0;
        Stack<Character> stack = new Stack<>();
        while(!queue.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(queue.poll());
                if (queue.isEmpty()) break;
            }

            char value = queue.peek();
            char compareValue = stack.peek();

            if (value == compareValue) {
                queue.poll();
                stack.pop();
            } else {
                stack.push(queue.poll());
            }
        }

        if(stack.isEmpty()) return 1;
        return 0;
    }
}
