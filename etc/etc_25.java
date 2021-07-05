import java.util.stream.LongStream;

public class etc_25 {
    // 프로그래머스 lv 1 : 두 정수 사이의 합 (https://programmers.co.kr/learn/courses/30/lessons/12912)
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        long sum = LongStream.rangeClosed(min, max)
                .sum();
        return sum;
    }
}
