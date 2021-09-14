package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n + 1];
        int count = 99;
        if (n < 100) {
            System.out.println(n);
            System.exit(0);
        }
        for (int i = 1; i < 100; i++) {
            check[i] = true;
        }

        label : for (int i = 1; i <= 9; i++) {
            int i1 = i;
            for (int j = -9; j < 9; j++) {
                int i2 = i1 + j;
                int i3 = i2 + j;
                if (i2 > 9 || i3 > 9 || i2 < 0 || i3 < 0) {
                    continue;
                }
                StringBuilder s = new StringBuilder();
                int hansu = Integer.parseInt(s.append(i1).append(i2).append(i3).toString());
                if(hansu > n) {
                    break label;
                }
                check[hansu] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}
