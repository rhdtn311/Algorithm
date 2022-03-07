package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int sum = arr[start] + arr[end];

            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            } else {
                count++;
                start++;
                end--;
            }

            if (start >= end) {
                break;
            }
        }

        System.out.println(count);
    }
}
