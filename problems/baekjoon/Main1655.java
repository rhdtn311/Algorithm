package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1655 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        while (N --> 0) {
            int input = Integer.parseInt(br.readLine());

            if (minHeap.size() != maxHeap.size()) {
                minHeap.add(input);

            } else {
                maxHeap.add(input);
            }

            if (minHeap.size() != 0 && maxHeap.size() != 0) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int min = minHeap.poll();
                    int max = maxHeap.poll();

                    minHeap.add(max);
                    maxHeap.add(min);
                }
            }

            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}

