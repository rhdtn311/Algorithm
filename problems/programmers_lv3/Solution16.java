package programmers_lv3;

public class Solution16 {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        int solution = s.solution(5, new int[]{1, 2, 5});
        System.out.println(solution);
    }

    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length][n + 1];

        for (int i = 0; i < money.length; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    if (j == 0 || j % money[i] == 0) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (money[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - money[i]];
                    }
                }
            }

        }

        return dp[money.length - 1][n];
    }
}
