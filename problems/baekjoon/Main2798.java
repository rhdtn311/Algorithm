package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2798 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                int sum = 0;
                for (int k = j+1; k < N; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M && M - sum < M - max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
