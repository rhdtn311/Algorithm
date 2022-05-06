package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
    static int n;
    static int m;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        answer = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        int L = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer now = queue.poll();

                for (int j = 0; j < graph.get(now).size(); j++) {
                    int next = graph.get(now).get(j);

                    if (answer[next] == 0) {
                        answer[next] = L;
                        queue.add(next);
                    }
                }
            }
            L++;
        }
    }
}
