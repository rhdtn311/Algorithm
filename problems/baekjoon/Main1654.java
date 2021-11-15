package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] KN = br.readLine().split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);

        long max = Integer.MIN_VALUE + 1;

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(upperBound(max, K, N, arr));
    }

    static int getSliceCount(long size, int K, int[] arr) {

        int count = 0;
        for (int i = 0; i < K; i++) {
            count += arr[i] / size;
        }

        return count;
    }

    static long upperBound(long max, int K, int N,int[] arr) {
        long start = 1;
        long end = max + 1;

        while (start < end) {
            long mid = (start + end) / 2;

            int count = getSliceCount(mid, K, arr);
            if (count >= N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}
