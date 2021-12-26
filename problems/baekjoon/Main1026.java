package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }

        System.out.println(sum);

    }
}
