package programers_lv2;

import java.util.PriorityQueue;

public class Solution8 {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;
        while (queue.peek() < K) {

            Integer min = queue.poll();
            if (queue.isEmpty()) {
                return -1;
            }

            queue.add(min + 2 * queue.poll());
            count++;
        }

        return queue.isEmpty() ? -1 : count;
    }
}
