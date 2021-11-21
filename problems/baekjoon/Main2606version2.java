package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main2606version2 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computers = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        visited = new boolean[computers + 1];

        for (int i = 0; i <= computers; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs(1);
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count - 1);
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                if (!visited[graph.get(now).get(i)]) {
                    queue.add(graph.get(now).get(i));
                    visited[graph.get(now).get(i)] = true;
                }
            }
        }
    }
}
