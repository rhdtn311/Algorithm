import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dynamicProgramming11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < n; testcase++) {
            int result = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 2;
            // dp[n] = dp[n-1] + dp[n-5]
            if (result > 5) {
                for (int i = 5; i <= result; i++) {
                    dp[i] = dp[i - 1] + dp[i - 5];
                }
            }

            System.out.println(dp[result - 1]);
        }
    }
}
