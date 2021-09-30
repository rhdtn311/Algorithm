package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[15][15];
        for (int i = 0; i < 15; i++) {
            dp[0][i] = i + 1;
            dp[i][0] = 1;
        }

        // 1 3
        for (int i = 0; i < 3; i++) {
            dp[1][3] += dp[0][i];
        }
        for (int i = 0; i < n; i++) {
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            for (int j = 1; j <= floor; j++) {
                for (int k = 1; k <= ho; k++) {
                    dp[j][k] = dp[j][k-1] + dp[j-1][k];
                }
            }
            System.out.println(dp[floor][ho-1]);
        }
    }

}
