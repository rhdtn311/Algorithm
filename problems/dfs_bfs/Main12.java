package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main12 {

    static int n, m;
    static int[][] arr;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static Queue<Point> queue = new ArrayDeque<>();

    static int count = 0;
    static int L = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new Point(i, j));
                } else if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        bfs();
        if (count != 0) System.out.println(-1);
        else System.out.println(L);

    }

    static void bfs() {

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        count--;
                    }
                }
            }
            L++;
            if (count == 0) break;
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
