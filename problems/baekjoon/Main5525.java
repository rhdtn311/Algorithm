package baekjoon;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[m];
        int answer = 0;

        for (int i = 1; i < m - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                dp[i + 1] = dp[i - 1] + 1;

                if (dp[i + 1] >= n && arr[i + 1 - 2 * n] == 'I') answer++;
            }
        }

        System.out.println(answer);
    }
}
