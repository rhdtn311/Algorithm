package programmers_lv3;

import java.util.*;

public class Solution11 {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        solution11.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public int solution(int n, int[][] results) {

        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            dp[results[i][0]][results[i][1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][k] && dp[k][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] || dp[j][i]) {
                    result++;
                }
            }

            if (result == n - 1) {
                answer ++ ;
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return answer;

    }
}
