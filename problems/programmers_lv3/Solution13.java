package programmers_lv3;

import java.util.Arrays;

public class Solution13 {

    static int[][] arr;
    public int solution(int m, int n, int[][] puddles) {
        arr = new int[n][m];

        for (int[] puddle : puddles) {
            arr[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        arr[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    arr[i][j] = arr[i][j - 1] % 1000000007;
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] % 1000000007;
                } else {
                    arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000007;
                }
            }
        }

        return arr[n - 1][m - 1] % 1000000007;
    }
}
