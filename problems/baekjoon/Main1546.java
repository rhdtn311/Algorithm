package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        double[] scores = new double[n];
        double max = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(s[i]);
            max = Math.max(scores[i], max);
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = (scores[i] / max) * 100;
            sum += scores[i];
        }

        System.out.println(sum/n);
    }
}
