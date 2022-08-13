package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14500 {

    static int max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(0, 0, i, j, arr, visited);
                visited[i][j] = false;
                check(i, j, arr);
            }
        }

        System.out.println(max);
    }

    static void dfs(int depth, int sum, int x, int y, int[][] arr, boolean[][] visited) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {

                visited[nx][ny] = true;
                dfs(depth + 1, sum + arr[nx][ny], nx, ny, arr, visited);
                visited[nx][ny] = false;

            }
        }
    }

    static void check(int x, int y, int[][] arr) {

        if (y + 2 < m && x + 1 < n) {  // ㅜ
            max = Math.max(max, arr[x][y] + arr[x + 1][y + 1] + arr[x][y + 1] + arr[x][y + 2]);
        }

        if (y + 2 < m && x - 1 >= 0) {  // ㅗ
            max = Math.max(max, arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x-1][y+1]);
        }

        if (x + 2 < n && y + 1 < m) { // ㅏ
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1]);
        }

        if (x + 2 < n && y - 1 >= 0) { // ㅓ
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+1][y-1]);
        }
    }
}
