package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11403 {

    static int n;

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("1")) {
                    graph[i][j] = 1;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n ; k ++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
