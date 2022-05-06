package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {

    static int count = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
        }

        visited[1] = true;
        dfs(1, visited);
        System.out.println(count);

    }

    static void dfs(int start, boolean[] visited) {

        if (start == n) {
            count++;
            return;
        }

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[graph.get(start).get(i)]) {
                visited[next] = true;
                dfs(next, visited);
                visited[next] = false;
            }
        }
    }
}
