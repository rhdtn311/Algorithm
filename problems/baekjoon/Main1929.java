package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            int num = i + i;
            while (num <= n) {
                arr[num] = true;
                num += i;
            }
        }

        for (int i = m; i <= n; i++) {
            if (i == 1) continue;
            if (!arr[i]) System.out.println(i);
        }
    }
}
