package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main13 {

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
                    bfs(new Point(i, j));
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    static void bfs(Point point) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;

                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
