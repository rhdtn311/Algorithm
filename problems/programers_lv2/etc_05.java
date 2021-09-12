package programers_lv2;

import java.util.*;

public class etc_05 {
    // 프로그래머스 lv 2 : 더 맵게 (https://programmers.co.kr/learn/courses/30/lessons/42626)
    public int solution(int[] scoville, int K) {

        // 우선순위 큐 (최소 힙) 삽입, 삭제 연산 시 시간복잡도 : O(log n)
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            if (queue.peek() >= K) return count;

            if (queue.size() == 1) {
                if (queue.peek() >= K) return count;
                return -1;
            }

            count++;
            int minValue = queue.poll();
            int nextMinValue = queue.poll();

            queue.add(minValue + nextMinValue * 2);
        }
        return count;
    }
}
