import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dynamicProgramming6 {
    // 백준 1464번 1로 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int x1 = Integer.parseInt(s[0]);
        int x2 = Integer.parseInt(s[1]);

        int[] dp = new int[x1 + 1];

        for (int i = 2; i <= x1; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {

                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        int[] dp2 = new int[x2 + 1];

        for (int i = 2; i <= x2; i++) {
            dp2[i] = dp2[i - 1] + 1;

            if (i % 3 == 0) {
                dp2[i] = Math.min(dp2[i], dp2[i / 3] + 1);
            } else if (i % 2 == 0) {

                dp2[i] = Math.min(dp2[i], dp2[i / 2] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));
    }
}
