package programers_lv1;

public class etc_38 {
    // 프로그래머스 lv1 : 정수 제곱근 판별 (https://programmers.co.kr/learn/courses/30/lessons/12934)
    public long solution(long n) {
        double value = Math.sqrt(n);
        long result = n % value == 0 ? (long)Math.pow(value+1,2) : -1;
        return result;
    }
}
