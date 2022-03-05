package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1937 {

    static int N;
    static int[][] arr;
    static int[][] dp;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y) {

        if (dp[x][y] == -1) {
            dp[x][y] = 1;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }

            if (arr[x][y] >= arr[nextX][nextY]) {
                continue;
            }

            if (dp[nextX][nextY] == -1) {
                dfs(nextX, nextY);
            }

            dp[x][y] = Math.max(dp[x][y], dp[nextX][nextY] + 1);
        }
    }
}
