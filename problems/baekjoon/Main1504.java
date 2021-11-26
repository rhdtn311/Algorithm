package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1504 {

    static int N;
    static int E;
    static int v1;
    static int v2;

    static final int INF = (int)200000000;

    static int[] dp;
    static boolean[] visited;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NE = br.readLine().split(" ");
        N = Integer.parseInt(NE[0]);
        E = Integer.parseInt(NE[1]);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            graph.get(Integer.parseInt(input[1])).add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
        }


        String[] v1v2 = br.readLine().split(" ");
        v1 = Integer.parseInt(v1v2[0]);
        v2 = Integer.parseInt(v1v2[1]);

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        System.out.println(result1 >= INF && result2 >= INF ? -1 : Math.min(result1, result2));
    }

    static int dijkstra(int start, int end) {

        dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int now = node.index;
            int dist = node.distance;

            if (dp[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                if (cost < dp[graph.get(now).get(i).index]) {
                    dp[graph.get(now).get(i).index] = cost;
                    pq.add(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }

        return dp[end];
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
