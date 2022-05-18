package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int coin = Integer.parseInt(br.readLine());
        int[] dp = new int[coin + 1];
        for (int i = 1; i <= coin; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    dp[i] = 1;
                    break;
                }
                if (i > arr[j]) dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
            }
        }
        System.out.println(dp[coin]);
    }
}
