package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {

    static int[][] dp = new int[41][2];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append(dp[0][0]).append(' ').append(dp[0][1]).append('\n');
                continue;
            } else if (n == 1) {
                sb.append(dp[1][0]).append(' ').append(dp[1][1]).append('\n');
                continue;
            } else {
                for (int j = 2; j <= n; j++) {
                    if (dp[j][0] == 0 || dp[j][1] == 0) {
                        dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                        dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
                    }
                }
            }
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }
}
