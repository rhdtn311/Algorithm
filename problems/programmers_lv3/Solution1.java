package programmers_lv3;

import java.util.Arrays;

public class Solution1 {
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long min = 1;
        long max = (long)times[times.length - 1] * n;

        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}
