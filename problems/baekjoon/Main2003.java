package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] s = br.readLine().split(" ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int count = 0;
        int start = 0;
        int end = 0;
        while (end < N && start < N) {

            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }

            if (sum > M) {
                start++;
            } else if (sum < M) {
                end++;
            } else {
                start++;
                end++;
                count++;
            }
        }


        System.out.println(count);

    }
}
