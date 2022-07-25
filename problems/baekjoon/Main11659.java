package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] arr = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) arr[i] = arr[i - 1] + Integer.parseInt(input[i - 1]);

        StringBuilder answer = new StringBuilder();

        while (M-- > 0) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);

            answer.append(arr[j] - arr[i - 1]).append("\n");
        }

        System.out.println(answer);
    }
}
