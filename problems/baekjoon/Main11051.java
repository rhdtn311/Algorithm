package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11051 {

    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        System.out.println(combination(n, r));
    }

    static int combination2(int n, int r) {
        for (int i = 0; i < 1001; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        return dp[n][r];
    }

    static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = (combination(n - 1, r - 1) + combination(n - 1, r)) % 10007;
    }
}
