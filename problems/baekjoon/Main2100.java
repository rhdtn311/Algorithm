package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2100 {

    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long min = 1;
        long max = K;
        while (min <= max) {

            long mid = (min + max) / 2;

            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= K) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid+1;
            }

        }

        System.out.println(result);
    }
}
