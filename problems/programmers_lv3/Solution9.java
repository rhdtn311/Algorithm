package programmers_lv3;

public class Solution9 {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            max = Math.max(max, dp[triangle.length - 1][i]);
        }

        return max;
    }
}
