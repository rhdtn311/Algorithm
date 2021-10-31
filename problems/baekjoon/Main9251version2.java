package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9251version2 {

    static Integer[][] dp;
    static char[] s1;
    static char[] s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dp = new Integer[s1.length][s2.length];

        System.out.println(LCS(s1.length-1, s2.length-1));
    }

    public static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (s1[x] == s2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
