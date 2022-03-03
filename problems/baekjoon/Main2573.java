package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2573 {

    static int N,M;
    static int[][] arr;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int year = 0;
        while (true) {

            int meltCount = 0;
            boolean[][] visited = new boolean[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j, visited);
                        count++;
                    }

                    if (arr[i][j] == 0) {
                        meltCount++;
                    }
                }
            }

            if (count >= 2) {
                break;
            }

            if (meltCount == N * M) {
                year= 0;
                break;
            }

            arr = oneYearLater();
            year++;
        }

        System.out.println(year);
    }

    static int[][] oneYearLater() {

        int[][] copyArr = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (arr[x][y] == 0) {
                    copyArr[x][y] = 0;
                }

                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + nx[i];
                    int nextY = y + ny[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                        continue;
                    }

                    if (arr[nextX][nextY] == 0) {
                         count++;
                    }
                }

                copyArr[x][y] = Math.max(0, arr[x][y] - count);
            }
        }

        return copyArr;
    }

    static void dfs(int x, int y, boolean[][] visited) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (arr[nextX][nextY] == 0) {
                continue;
            }

            visited[nextX][nextY] = true;
            dfs(nextX, nextY, visited);
        }
    }
}
