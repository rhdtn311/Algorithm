package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int fix = Integer.parseInt(s[0]);
        int variable = Integer.parseInt(s[1]);
        int profit = Integer.parseInt(s[2]);

        int n = profit - variable;

        if (n == 0 || ((fix / n) + 1) < 0) {
            System.out.println(-1);
        } else {
            System.out.println((fix / n) + 1);
        }
    }
}
