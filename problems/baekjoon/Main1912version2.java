package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1912version2 {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        dp[0] = arr[0];

        dfs(n - 1);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }

    static int dfs(int idx) {
        if (dp[idx] == null) {
            dp[idx] = Math.max(dfs(idx - 1) + arr[idx], arr[idx]);
        }

        return dp[idx];
    }
}