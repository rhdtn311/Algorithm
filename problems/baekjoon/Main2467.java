package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int zero = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        int start = 0;
        int end = n - 1;
        int sum = 0;
        while (start < end) {
            sum = arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(zero)) {
                answer1 = Math.min(arr[start], arr[end]);
                answer2 = Math.max(arr[start], arr[end]);

                zero = sum;
            } else {
                if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
