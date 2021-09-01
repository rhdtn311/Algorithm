public class Fibonacci {

    // 기본 피보나치 : O(2^n)
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Top-Down 방식 : O(n)
    static int[] memory = new int[101];
    public static int fibonacci2(int n) {
        if (n == 0 || n == 1) return n;

        if (memory[n] == 0) {
            memory[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        }

        return memory[n];
    }

    // Botton-up 방식 : O(n)
    static int[] dp = new int[101];
    public static int fibonacci3(int n) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
