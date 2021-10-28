package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156version2 {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));

    }

    public static int find(int idx) {
        if (dp[idx] == null) {
            dp[idx] = Math.max(find(idx - 1), Math.max(find(idx - 3) + arr[idx-1], find(idx - 2)) + arr[idx]);
        }

        return dp[idx];
    }
}
