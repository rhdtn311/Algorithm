package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[n - 1] - arr[0];
        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            int prev = arr[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - prev >= mid) {
                    count++;
                    prev = arr[i];
                }
            }

            if (count >= c) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
