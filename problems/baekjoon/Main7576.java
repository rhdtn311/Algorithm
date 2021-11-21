package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main7576 {

    static int[][] map;
    static boolean[][] visited;

    static int N;
    static int M;

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    static ArrayList<Integer> xys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        map = new int[N][M];

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    xys.add(i);
                    xys.add(j);
                    visited[i][j] = true;
                }
            }
        }

        bfs(xys);

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                } else {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
        }

        System.out.println(max - 1);

    }

    static void bfs(ArrayList<Integer> xys) {

        Queue<Integer> queue = new LinkedList<>(xys);

        while (!queue.isEmpty()) {

            int nowX = queue.poll();
            int nowY = queue.poll();

            visited[nowX][nowY] = true;

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];


                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

                    if (map[nextX][nextY] == -1) {
                        continue;
                    }

                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    map[nextX][nextY] = map[nowX][nowY] + 1;

                    visited[nextX][nextY] = true;

                    queue.add(nextX);
                    queue.add(nextY);

                }
            }
        }
    }
}
