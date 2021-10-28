package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10844version2 {

    static int n;
    static Long[][] dp;

    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long count = 0;
        for (int i = 1; i < 10; i++) {
            count += find(n, i);
        }

        System.out.println(count % mod);

    }

    public static long find(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = find(digit - 1, 1);
            } else if (val == 9) {
                dp[digit][val] = find(digit - 1, 8);
            } else {
                dp[digit][val] = (find(digit - 1, val - 1) + find(digit - 1, val + 1));
            }
        }

        return dp[digit][val] % mod;
    }
}
