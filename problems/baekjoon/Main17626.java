package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main17626 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                num = Math.min(num, dp[i - j * j]);
            }
            dp[i] = num + 1;
        }

        System.out.println(dp[n]);
    }
}
