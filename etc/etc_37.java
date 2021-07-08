import java.util.Arrays;
import java.util.Comparator;

public class etc_37 {
    // 프로그래머스 lv 1 : 정수 내림차순으로 배치하기 (https://programmers.co.kr/learn/courses/30/lessons/12933)_
    public long solution(long n) {

        String s = String.valueOf(n);
        String[] split = s.split("");
        String result = "";
        long[] longs = Arrays.stream(split).sorted(Comparator.reverseOrder())
                .mapToLong(Long::valueOf).toArray();

        for (long l : longs) {
            result += l;
        }
        return Long.valueOf(result);
    }

    public static void main(String[] args) {
        etc_37 s = new etc_37();
        System.out.println(s.solution(118372));
    }
}
