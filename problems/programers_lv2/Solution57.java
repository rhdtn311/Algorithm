package programers_lv2;

import java.util.*;

public class Solution57 {
    // 1234567

    public static int solution(int n) {

        int[] dp = new int[100001];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n] % 1234567;
    }
}
