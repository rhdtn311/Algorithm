package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main18352 {

    static int N, M, K, X;

    static final int INF = (int) 1e9;

    static int[] d;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");

            graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
        }

        d = new int[N + 1];

        Arrays.fill(d, INF);

        dijkstra(X);

        boolean isAnswer = false;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == K) {
                System.out.println(i);
                isAnswer = true;
            }
        }

        if (!isAnswer) System.out.println(-1);

    }

    static void dijkstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(start);
        d[start] = 0;

        while (!pq.isEmpty()) {
            Integer now = pq.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + 1;

                if (cost < d[graph.get(now).get(i)]) {
                    d[graph.get(now).get(i)] = cost;
                    pq.add(graph.get(now).get(i));
                }
            }
        }

    }
}
