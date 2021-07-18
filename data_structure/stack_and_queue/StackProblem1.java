package stack_and_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackProblem1 {
    // 프로그래머스 lv2 : 기능 개발 (https://programmers.co.kr/learn/courses/30/lessons/42586)
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            double remainPercent = 100 - progresses[i];
            double speedPerDay = speeds[i];

            queue.add((int)Math.ceil(remainPercent / speedPerDay));
        }

        System.out.println(queue);
        int count = 0;
        int deployWork = queue.peek();
        while (!queue.isEmpty()) {

            while ( !(queue.peek()==null) && queue.peek() <= deployWork) {
                queue.poll();
                count ++;
            }

            result.add(count);
            if (queue.peek() != null) {
                deployWork = queue.peek();
            }
            count = 0;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
