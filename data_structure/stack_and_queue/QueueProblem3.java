package stack_and_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem3 {
    // 프로그래머스 lv2 : 다리를 지나는 트럭 (https://programmers.co.kr/learn/courses/30/lessons/42583)
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Arrays.sort(truck_weights);

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();

        for (int truck : truck_weights) {
            waiting.add(truck);
        }

        int remainWeight = weight;
        int count = 0;
        int zeroCount = 0;
        do {
            count++;

            if (bridge.size() >= bridge_length) {
                Integer removeTruck = bridge.poll();
                remainWeight += removeTruck;
            }

            if (waiting.isEmpty()) {
                bridge.add(0);
                zeroCount++;
                if (zeroCount == bridge_length) {
                    break;
                }
                continue;
            }

            if (remainWeight - waiting.peek() >= 0) {
                Integer truck = waiting.poll();
                remainWeight -= truck;
                bridge.add(truck);
            } else {
                bridge.add(0);
            }

        } while (!waiting.isEmpty() || !bridge.isEmpty());

        return count;
    }
}
