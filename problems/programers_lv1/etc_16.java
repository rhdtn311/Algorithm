package programers_lv1;

import java.util.Arrays;

public class etc_16 {
    // 프로그래머스 lv 1 : 예산 ( https://programmers.co.kr/learn/courses/30/lessons/12982)
    public int solution(int[] d, int budget) {

        int count = 0;
        Arrays.sort(d);
        for (int i : d) {
            if (budget - i >= 0) {
                count++;
                budget -= i;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        etc_16 s = new etc_16();
        int solution = s.solution(new int[]{1,1,1,1,1}, 8);
        System.out.println(solution);
    }
}
