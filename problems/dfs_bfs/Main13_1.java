package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13_1 {
    static int n;
    static int[][] graph;

    static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx][ny] == 1) {
                graph[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
