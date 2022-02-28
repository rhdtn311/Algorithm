package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2512version2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int min = 0;
        int max = arr[arr.length - 1];
        while (min <= max) {
            int mid = (min + max) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid >= arr[i]) {
                    sum += arr[i];
                } else {
                    sum += mid;
                }
            }

            if (sum > M) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
