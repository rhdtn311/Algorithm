package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10 {

    static int[][] arr = new int[7][7];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited = new boolean[7][7];

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(count);


    }

    static void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && !visited[nx][ny] && arr[nx][ny] == 0) {
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
