package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);

        int minValue = Math.min(n1, n2);

        int max = 0;
        for (int i = 1; i <= minValue; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
        System.out.println(n1/max*n2);
    }
}
