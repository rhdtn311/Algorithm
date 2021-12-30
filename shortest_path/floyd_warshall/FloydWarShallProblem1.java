package floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarShallProblem1 {

    static int N;

    static int[][] graph;

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("Y")) {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i == j) continue;
                    if (graph[i][j] == 0) {
                        if (graph[i][k] == 1 && graph[j][k] == 1) {
                            graph[i][j] = 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    sum += 1;
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
