package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int money = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= money) {
                count += money / arr[i];
                money %= arr[i];
            }
        }

        System.out.println(count);
    }
}
