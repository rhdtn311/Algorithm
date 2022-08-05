package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Person> queue = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            queue.add(new Person(i, Integer.parseInt(input[i])));
            pq.offer(Integer.parseInt(input[i]));
        }

        int count = 1;
        while (!pq.isEmpty()) {
            Integer now = pq.peek();
            Person person = queue.poll();
            if (person.priority == now) {
                if (person.order == M) break;
                pq.poll();
                count++;
            } else queue.offer(person);
        }

        System.out.println(count);
    }

    static class Person  {
        int order;
        int priority;

        public Person(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
