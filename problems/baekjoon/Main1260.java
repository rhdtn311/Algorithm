package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main1260 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs(V);

            System.out.println(sb);
    }

    static void dfs(int now) {

        visited[now] = true;

        sb.append(now).append(' ');

        for (int i = 0; i < graph.get(now).size(); i++) {
            if (!visited[graph.get(now).get(i)]) {
                dfs(graph.get(now).get(i));
            }
        }
    }

    static void bfs(int start) {

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            sb.append(now).append(' ');

            for (int val : graph.get(now)) {
                if (!visited[val]) {
                    queue.add(val);
                    visited[val] = true;
                }
            }
        }
    }
}
