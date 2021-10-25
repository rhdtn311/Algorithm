package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9184 {

    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            if (a == -1 && b == -1 && c == -1) {
                System.exit(0);
            }

            int result = w(a + 50, b + 50, c + 50);

            System.out.println("w(" + a +", " +b + ", " + c +") = " + result);
        }
    }

    public static int w(int a, int b, int c) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 50 || b <= 50 || c <= 50) {
            dp[a][b][c] = 1;
            return dp[a][b][c];

        } else if (a > 70 || b > 70 || c > 70) {
            dp[70][70][70] = w(70,70,70);
            dp[a][b][c] = dp[70][70][70];
            return dp[a][b][c];

        } else if (a < b && b < c) {
            return dp[a][b][c] =  w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);

        } else {
            return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }
    }
}
