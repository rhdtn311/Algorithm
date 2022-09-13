package programers_lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution65 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int val : queue1) {
            sum1 += val;
            q1.offer(val);
        }

        for (int val : queue2) {
            sum2 += val;
            q2.offer(val);
        }

        int count = 0;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                Integer poll1 = q1.poll();
                q2.offer(poll1);
                sum1 -= poll1;
                sum2 += poll1;
            } else {
                Integer poll2 = q2.poll();
                sum2 -= poll2;
                sum1 += poll2;
                q1.offer(poll2);
            }
            count++;

            if (count > queue1.length + queue2.length) return -1;
        }

        return count;
    }
}
