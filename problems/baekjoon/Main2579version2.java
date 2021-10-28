package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579version2 {

    static int n;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++ ){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));
    }

    public static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 3) + arr[n - 1], find(n - 2)) + arr[n];
        }

        return dp[n];
    }
}
