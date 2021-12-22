package programers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution19version2 {
    public int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>();
        for (int p : priorities) {
            queue.add(p);
        }

        Arrays.sort(priorities);

        int l = location;
        int size = priorities.length - 1;
        int answer = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            l--;

            if (now == priorities[size - answer]) {
                answer++;

                if (l < 0) {
                    return answer;
                }
            } else {
                queue.offer(now);

                if (l < 0) {
                    l = queue.size() - 1;
                }
            }
        }

        return 0;
    }
}
