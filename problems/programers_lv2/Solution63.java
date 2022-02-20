package programers_lv2;

import java.util.Arrays;

public class Solution63 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    static int solution(int[][] land) {

        int[][] dp = new int[land.length][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = findMax(dp[i - 1], j);

                dp[i][j] = land[i][j] + max;
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, dp[land.length - 1][i]);
        }

        return result;
    }

    static int findMax(int[] arr, int except) {

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!(i == except)) {
                max = Math.max(max, arr[i]);
            }
        }

        return max;
    }
}
