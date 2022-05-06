package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main10_1 {

    static int n;
    static int m;
    static int answer = 0;

    static int[][] graph;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        visited = new boolean[n + 1];

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            graph[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
        }

        visited[1] = true;
        dfs(1);

        System.out.println(answer);
    }

    static void dfs(int node) {
        if (node == n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            int next = graph[node][i];

            if (!visited[i] && next == 1) {
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }
}
