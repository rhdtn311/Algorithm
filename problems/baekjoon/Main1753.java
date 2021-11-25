package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main1753 {

    static int V;
    static int E;
    static int K;

    static int start;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int[] dp;

    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);

        start = Integer.parseInt(br.readLine());

        dp = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");

            graph.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i] = INF;
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            System.out.println(dp[i] == INF ? "INF" : dp[i]);
        }


    }

    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int value = node.value;
            int now = node.index;

            if (dp[now] < value) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).value;

                if (cost < dp[graph.get(now).get(i).index]) {
                    dp[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
