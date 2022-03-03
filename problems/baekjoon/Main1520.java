package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1520 {

    static int M;
    static int N;

    static int[][] arr;

    static boolean[][] visited;
    static int[][] dp;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");

        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);
        arr = new int[M][N];
        visited = new boolean[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }

        visited[0][0] = true;

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static void dfs(int x, int y) {

        if (x == M - 1 && y == N - 1) {
            dp[x][y] = 1;
            return;
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }

            if (arr[nextX][nextY] < arr[x][y]) {
                if (dp[nextX][nextY] != -1) {
                    dp[x][y] += dp[nextX][nextY];
                } else {
                    dfs(nextX, nextY);
                    dp[x][y] += dp[nextX][nextY];
                }
            }
        }
    }
}
