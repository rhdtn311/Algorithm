package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Schedule> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Schedule(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int answer = 0;
        int j = 0;
        int max = list.get(0).day;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).day == i) {
                    pq.offer(list.get(j).pay);
                } else break;
            }
            if (!pq.isEmpty()) answer += pq.poll();
        }


        System.out.println(answer);
    }

    static class Schedule implements Comparable<Schedule> {
        int pay;
        int day;

        public Schedule(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.day - this.day;
        }
    }
}
