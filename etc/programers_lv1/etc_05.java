package programers_lv1;

public class etc_05 {
    public int solution(int[] a, int[] b) {

        // 프로그래머스 level 1 : 내적 ( https://programmers.co.kr/learn/courses/30/lessons/70128)

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}
