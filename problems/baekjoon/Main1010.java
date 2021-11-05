package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            int left = Integer.parseInt(s[0]);
            int right = Integer.parseInt(s[1]);

            sb.append(combination(right, left)).append("\n");
        }
        System.out.println(sb);
    }

    static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }


}
