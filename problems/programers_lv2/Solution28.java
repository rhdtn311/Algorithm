package programers_lv2;

import java.util.Arrays;

public class Solution28 {

    static final int INF = (int) 1e9;

    static int[][] graph;

    public static int solution(int N, int[][] road, int K) {

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        for (int[] r : road) {
            graph[r[0]-1][r[1]-1] = Math.min(graph[r[0]-1][r[1]-1],r[2]);
            graph[r[1]-1][r[0]-1] = Math.min(graph[r[1]-1][r[0]-1],r[2]);
        }

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (graph[0][i] <= K) {
                result++;
            }
        }

        return result;
    }
}
