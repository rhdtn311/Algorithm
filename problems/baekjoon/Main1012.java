package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1012 {

    static int M;
    static int N;
    static int K;

    static int[][] map;

    static int[] nx = new int[]{0, 0, -1, 1};
    static int[] ny = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            String[] input = br.readLine().split(" ");

            M = Integer.parseInt(input[0]); // 가로
            N = Integer.parseInt(input[1]); // 세로
            K = Integer.parseInt(input[2]); // 배추 수

            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                String[] mapInfo = br.readLine().split(" ");

                int mapM = Integer.parseInt(mapInfo[0]);
                int mapN = Integer.parseInt(mapInfo[1]);

                map[mapN][mapM] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {

        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

                if (map[nextX][nextY] == 0) {
                    continue;
                }

                dfs(nextX, nextY);
            }
        }
    }
}
