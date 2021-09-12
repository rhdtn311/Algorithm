package programers_lv1;

import java.util.stream.IntStream;

public class etc_17 {
    // 프로그래머스 lv 1 : 약수의 개수와 덧셈 (https://programmers.co.kr/learn/courses/30/lessons/77884)
    public int solution(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            int num = checkYaksu(i);
            if (num % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }

        return sum;
    }

    public int checkYaksu(int num) {
        int count = 0;
        int result = (int)IntStream.rangeClosed(1, num)
                .filter(i -> num % i == 0)
                .count();

        return count + result;
    }

    public static void main(String[] args) {
        etc_17 s = new etc_17();
        int solution = s.solution(24, 27);
        System.out.println(solution);
    }
}
