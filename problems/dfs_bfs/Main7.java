package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main7 {

    static int n, m;
    static int[][] dp;

    static int dfs(int n, int m) {

        if (dp[n][m] != 0) return dp[n][m];

        if (m == 1) return n;
        if (n == 1 || n == m) return 1;

        return dp[n][m] = dfs(n - 1, m - 1) + dfs(n - 1, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        dp = new int[n + 1][m + 1];

        System.out.println(dfs(n, m));

    }
}
