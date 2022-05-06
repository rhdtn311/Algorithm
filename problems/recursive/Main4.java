package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        System.out.println(fibonacci(n));
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }

    }

    static int fibonacci(int n) {
        if (dp[n] != 0) return dp[n];

        if (n <= 2) {
            dp[n] = 1;
            return 1;
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
