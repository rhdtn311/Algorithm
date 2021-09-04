package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraProblem1 {
    public static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance =distance;
        }

        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }

    static int INF = (int)1e9;
    static int V,E,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dp = new int[20001];
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dp[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if (dist > dp[now]) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;
                if (dp[graph.get(now).get(i).index] > cost) {
                    dp[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int z = Integer.parseInt(s1[2]);

            graph.get(x).add(new Node(y,z));
        }

        Arrays.fill(dp, INF);

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (dp[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dp[i]);
            }
        }

    }
}