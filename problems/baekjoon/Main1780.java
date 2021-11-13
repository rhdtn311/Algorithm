package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1780 {

    static int N;
    static int[][] arr;

    static int minusOneCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;

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

        System.out.println(minusOneCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            if (arr[x][y] == -1) {
                minusOneCount++;
            } else if (arr[x][y] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = x; i < x + size; i += newSize) {
            for (int j = y; j < y + size; j += newSize) {
                dfs(i, j, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int now = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != now) {
                    return false;
                }
            }
        }

        return true;

    }
}
