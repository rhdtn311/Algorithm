package programers_lv1;

import java.util.Arrays;
import java.util.Stack;

public class etc_36 {
    // 프로그래머스 lv 1 : 자연수 뒤집어 배열로 만들기 (https://programmers.co.kr/learn/courses/30/lessons/12932)
    public int[] solution(long n) {
        String s = String.valueOf(n);
        String[] split = s.split("");
        Stack<String> stack = new Stack<>();

        for (String value : split) {
            stack.push(value);
        }

        int[] result =new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        etc_36 s = new etc_36();
        int[] solution = s.solution(934821943l);
        System.out.println(Arrays.toString(solution));
    }
}
