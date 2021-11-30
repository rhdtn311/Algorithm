package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] HW = br.readLine().split(" ");
        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);

        String[] s = br.readLine().split(" ");

        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }


        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for (int f = 0; f < i; f++) {
                left = Math.max(arr[f], left);
            }

            for (int b = i + 1; b < W; b++) {
                right = Math.max(arr[b], right);
            }

            int min = Math.min(left, right);
            result += Math.max (0,min - arr[i]);
        }

        System.out.println(result);
    }
}
