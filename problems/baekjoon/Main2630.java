package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2630 {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void dfs(int x, int y, int n) {
        if (x + n > N || y + n > N) {
            return;
        }

        if (checkFull(x, y, n)) {
            return;
        }

        dfs(x, y, n / 2);
        dfs(x + n / 2, y + n / 2, n/2);
        dfs(x + n / 2, y, n/2);
        dfs(x, y + n / 2, n / 2);
    }

    static boolean checkFull(int x, int y, int n) {

        int now = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (now != arr[i][j]) {
                    return false;
                }
            }
        }

        if (now == 1) {
            blue++;
        } else {
            white++;
        }

        return true;
    }
}
