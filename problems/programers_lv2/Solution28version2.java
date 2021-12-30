package programers_lv2;

import java.util.*;

public class Solution28version2 {

    static final int INF = (int) 1e9;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int[] d;

    public static int solution(int N, int[][] road, int K) {

        d = new int[N + 1];

        Arrays.fill(d, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra(1);

        int result = 0;
        for (int i = 1; i < d.length; i++) {
            if (d[i] <= K) {
                result ++;
            }
        }

        return result;

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.distance;
            int now = node.index;

            if (d[now] < distance) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;

                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;

                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return  -1;
            }
            return 1;
        }
    }
}
