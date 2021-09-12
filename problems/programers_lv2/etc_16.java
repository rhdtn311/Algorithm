package programers_lv2;

import java.math.BigInteger;

public class etc_16 {
    // 프로그래머스 lv 2 : 멀쩡한 사각형
    public long solution(int w, int h) {

        long greatestCommonFactor = getGreatestCommonFactor(w, h);

        return (long)w * h - (w+h-greatestCommonFactor);
    }

    // 최대 공약수 구함
    public static long getGreatestCommonFactor(long w, long h) {
        long min = Math.min(w , h);
        for (long i = min; i > 0; i--) {
            if (w % i == 0  && h % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        etc_16 s = new etc_16();
        long greatestCommonFactor = getGreatestCommonFactor(3,6);
        System.out.println(greatestCommonFactor);

        long solution = s.solution(8, 12);
        System.out.println(solution);
    }
}
