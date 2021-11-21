package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2178 {

    static int N;
    static int M;

    static int[][] map;

    static boolean[][] visited;

    static int[] nx = new int[]{0, 0, -1, 1};
    static int[] ny = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        visited = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);


    }

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int nowX = queue.poll();
            int nowY = queue.poll();

            if (nowX == N && nowY == M) {
                System.out.println(map[N][M]);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

                    if (map[nextX][nextY] == 0) {
                        continue;
                    }

                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    map[nextX][nextY] = map[nowX][nowY] + 1;

                    queue.add(nextX);
                    queue.add(nextY);

                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
