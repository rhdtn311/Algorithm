package kakao2022intern;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int solution = s.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println(solution);
    }
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long average = (sum1 + sum2) / 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int v : queue1) {
            q1.offer(v);
        }
        for (int v : queue2) {
            q2.offer(v);
        }

        int count = 0;
        while (true) {
            if (count > 100000000) {
                return -1;
            }

            if (sum1 > average) {
                count++;
                int poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
                sum2 += poll;

                System.out.println("poll : " + poll);
            }
            else if (sum2 > average) {
                count++;
                int poll = q2.poll();
                q1.offer(poll);
                sum2 -= poll;
                sum1 += poll;
                System.out.println("poll : " + poll);

            }
            else break;
        }

        return count;
    }
}
