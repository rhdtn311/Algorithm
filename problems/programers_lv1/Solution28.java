package programers_lv1;

import java.util.stream.LongStream;

public class Solution28 {
    public long solution(int a, int b) {
        return LongStream.rangeClosed(Math.min(a,b), Math.max(a,b)).sum();
    }
}
