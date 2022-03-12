package programmers_lv3;

import java.util.Arrays;

public class Solution13 {

    static long[][] dp;
    static int[][] arr;

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int solution = solution13.solution(4, 3, new int[][]{{2, 2}});
        System.out.println(solution);
    }

    public int solution(int m, int n, int[][] puddles) {
        arr = new int[n][m];
        dp = new long[n][m];

        for (int[] puddle : puddles) {
            arr[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < m; i++) {
            if (arr[0][i] == -1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][0] == -1) {
                break;
            }
            dp[i][0] = 1;
        }



        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return (int)dp[n - 1][m - 1] % 1000000007;
    }
}
