package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int score = Integer.parseInt(input[0]);
            int time = Integer.parseInt(input[1]);
            for (int j = m; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }

        System.out.println(dp[m]);
    }
}

