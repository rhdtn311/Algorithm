package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1926 {

    static boolean[][] visited;
    static int maxArea = 0;
    static int count = 0;
    static int[][] arr;
    static int value = 0;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        visited = new boolean[N][M];

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {

                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    value = 0;
                    dfs(i, j, 1);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    static void dfs(int x, int y, int depth) {

        visited[x][y] = true;
        value++;
        maxArea = Math.max(maxArea, value);

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (arr[nextX][nextY] == 0) {
                continue;
            }

            dfs(nextX, nextY, depth + 1);
        }
    }
}
