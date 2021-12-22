package programers_lv2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution19 {
    public int solution(int[] priorities, int location) {

        Queue<Integer> indexQueue = new LinkedList<>();
        Queue<Integer> priorityQueue = new LinkedList<>();
        Queue<Integer> orderQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            indexQueue.add(i);
            priorityQueue.add(priorities[i]);
        }

        Arrays.sort(priorities);
        for (int i = priorities.length - 1; i >= 0; i--) {
            orderQueue.add(priorities[i]);
        }

        int count = 0;
        while (!orderQueue.isEmpty()) {
            Integer order = orderQueue.peek();
            Integer priority = priorityQueue.poll();
            Integer index = indexQueue.poll();

            if (order == priority) {

                count++;
                orderQueue.poll();

                if (index == location) {
                    return count;
                }

            } else {
                priorityQueue.offer(priority);
                indexQueue.offer(index);
            }
        }

        return 0;
    }
}
