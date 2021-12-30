package programers_lv2;

import java.util.*;

public class Solution30 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> pq = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            pq.add(new Truck(bridge_length, truck_weight));
        }

        Queue<Truck> queue = new LinkedList<>();

        int remainWeight = weight;
        int count = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {

            count++;

            if (!queue.isEmpty()) {
                if (queue.peek().remain == 0) {
                    Truck poll = queue.poll();
                    remainWeight += poll.weight;
                }
            }

            if (!pq.isEmpty() && remainWeight >= pq.peek().weight) {
                Truck truck = pq.poll();
                queue.offer(truck);
                remainWeight -= truck.weight;
            }

            for (Truck t : queue) {
                t.move();
            }

        }

        return count;
    }

    static class Truck implements Comparable<Truck> {
        int remain;
        int weight;

        public Truck(int remain, int weight) {
            this.remain = remain;
            this.weight = weight;
        }

        void move() {
            this.remain--;
        }

        @Override
        public int compareTo(Truck o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "remain=" + remain +
                    ", weight=" + weight +
                    '}';
        }
    }
}
