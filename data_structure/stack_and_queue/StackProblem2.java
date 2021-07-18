package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackProblem2 {
    // 프로그래머스 lv 2 : 프린터 (https://programmers.co.kr/learn/courses/30/lessons/42587)
    public int solution(int[] priorities, int location) {

        Queue<PrintWork> queue = new LinkedList<>();

        int index = 0;
        for (int i : priorities) {
            PrintWork printWork = new PrintWork(index,i);
            queue.add(printWork);
            index ++;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int maxPriority = maxPriority(queue);
            if (maxPriority > queue.peek().priority) {
                queue.add(queue.poll());
            } else {
                PrintWork printWork = queue.poll();
                count++;
                if (location == printWork.index) {
                    return count;
                }
            }
        }
        return 0;
    }

    public class PrintWork {
        public int index;
        public int priority;

        public PrintWork(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    // 가장 높은 중요도를 리턴턴
    public int maxPriority(Queue<PrintWork> queue) {
        int max = 0;
        for (PrintWork p : queue) {
            if (p.priority > max) {
                max = p.priority;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        StackProblem2 s = new StackProblem2();
        int solution = s.solution(new int[]{1,1}, 1);
        System.out.println(solution);
    }
}
