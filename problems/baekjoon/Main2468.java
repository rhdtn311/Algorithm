package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2468 {

    static int[] nx = {-1, 0, 1, 0};
    static int[] ny = {0, -1, 0, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int k = 0; k <= max; k++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > k) {
                        count += dfs(i, j, k, arr, visited);
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);

    }

    static int dfs(int x, int y, int limit,int[][] arr, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (arr[nextX][nextY] <= limit) {
                continue;
            }

            visited[nextX][nextY] = true;

            dfs(nextX, nextY, limit, arr, visited);
        }

        return 1;
    }

}
