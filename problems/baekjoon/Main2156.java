package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {

    static int[] arr;
    static int[] dp;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            if (arr[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i-1],Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
            }
        }

        for (int i = 0; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
