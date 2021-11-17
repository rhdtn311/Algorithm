package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int min = Integer.MAX_VALUE;

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = arr[N - 1] - arr[0];                                                                               ;

        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
                }
        }

        while (min < max) {
            int mid = (min + max) / 2;

            int count = 1;
            int now = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - now >= mid) {
                    now = arr[i];
                    count++;
                }
            }

            if (count >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }

}
