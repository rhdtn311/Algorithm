package programers_lv1;

import java.util.Arrays;

public class etc_07 {
    // 프로그래머스 level 1 : 음향 더하기 ( https://programmers.co.kr/learn/courses/30/lessons/76501)
    public int solution(int[] absolutes, boolean[] signs) {

        for (int i = 0; i<absolutes.length; i++ ) {
                if (signs[i] == true ) {
                    continue;
                } else {
                    absolutes[i] = -(absolutes[i]);
                }
        }
        return Arrays.stream(absolutes).sum();
    }

    public static void main(String[] args) {
        etc_07 s = new etc_07();
        int solution = s.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
        System.out.println(solution);
    }
}
