package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int pick1 = -1;
        int pick2 = -1;

        int left = 0;
        int right = arr.length - 1;
        int max = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < max) {
                max = Math.abs(sum);

                pick1 = arr[left];
                pick2 = arr[right];

            }

            if (sum > 0) {
                right--;
            } else {
                left ++;
            }
        }

        System.out.println(pick1 + " " + pick2);

    }
}
