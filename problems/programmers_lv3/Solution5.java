package programmers_lv3;

import java.util.*;

public class Solution5 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int INF = (int) 1e9;

    static int[] dp;

    static int max = 0;

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        solution5.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public int solution(int n, int[][] edge) {

        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        Arrays.fill(dp, INF);

        dijkstra(1);

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max == dp[i]) {
                count++;
            }
        }

        return count;
    }

    void dijkstra(int start) {

        Queue<Integer> pq = new LinkedList<>();

        pq.offer(start);
        dp[start] = 0;

        while (!pq.isEmpty()) {

            Integer now = pq.poll();

            if (dp[now] != INF) {
                max = Math.max(max, dp[now]);
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + 1;

                if (dp[graph.get(now).get(i)] > cost) {
                    dp[graph.get(now).get(i)] = cost;
                    pq.offer(graph.get(now).get(i));
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }

//    class Node implements Comparable<Node> {
//        int index;
//        int distance;
//
//        public Node(int index, int distance) {
//            this.index = index;
//            this.distance = distance;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.distance - o.distance;
//        }
//    }

}
