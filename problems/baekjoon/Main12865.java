package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main12865 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        dp = new int[k + 1][n + 1];

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            weight[i] = Integer.parseInt(s1[0]);
            value[i] = Integer.parseInt(s1[1]);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (weight[j] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - weight[j]][j - 1] + value[j]);
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}