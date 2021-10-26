package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];
        String[] s = br.readLine().split(" ");
        dp[0][0] = Integer.parseInt(s[0]);
        dp[0][1] = Integer.parseInt(s[1]);
        dp[0][2] = Integer.parseInt(s[2]);
        for (int i = 1; i < n; i++) {
            String[] RGB = br.readLine().split(" ");
            int R = Integer.parseInt(RGB[0]);
            int G = Integer.parseInt(RGB[1]);
            int B = Integer.parseInt(RGB[2]);
            dp[i][0] = R + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = G + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = B + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
    }
}
