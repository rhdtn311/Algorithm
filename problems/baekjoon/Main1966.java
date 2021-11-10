package baekjoon;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Node> queue = new LinkedList<>();

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                pq.add(Integer.parseInt(s[i]));
                queue.add(new Node(i, Integer.parseInt(s[i])));
            }

            int count = 0;
            while (!pq.isEmpty()) {
                int now = pq.poll();
                count++;

                while (true) {
                    if (queue.peek().value == now) {
                        Node node = queue.poll();
                        if (node.index == M) {
                            System.out.println(count);
                        }
                        break;
                    } else {
                        queue.offer(queue.poll());
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}


