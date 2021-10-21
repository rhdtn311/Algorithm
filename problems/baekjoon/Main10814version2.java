package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10814version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder[] arr = new StringBuilder[201];

        for (int i = 0; i < 201; i++) {
            arr[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            arr[Integer.parseInt(s[0])].append(s[0]).append(" ").append(s[1]).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder sb2 : arr) {
            sb.append(sb2);
        }

        System.out.println(sb);
    }
}
