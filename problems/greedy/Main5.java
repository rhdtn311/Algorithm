package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main5 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[][] isFriend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

         isFriend = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        for (int i = 1; i <= n; i++) {
            bfs(n, i);
        }

        String[] p = br.readLine().split(" ");
        System.out.println(isFriend[Integer.parseInt(p[0])][Integer.parseInt(p[1])] ? "YES" : "NO");

    }

    static void bfs(int n, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                if (!visited[graph.get(now).get(i)]) {
                    visited[graph.get(now).get(i)] = true;
                    isFriend[start][graph.get(now).get(i)] = true;
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

    }
}
