package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] check = new int[26];
        Arrays.fill(check, -1);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (check[n] != -1) {
                continue;
            }
                check[n] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < check.length; i++) {
                sb.append(check[i]).append(" ");
        }
        System.out.println(sb);
    }
}
