package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = new int[N];

        String[] trees = br.readLine().split(" ");

        int max = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(trees[i]);
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int min = 0;
        while (min < max) {
            int mid = (min + max) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.max(0, arr[i] - mid);
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
