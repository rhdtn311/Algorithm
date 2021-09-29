package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i1 = 1;
        int i2 = 1;

        boolean up = true;
        for (int i = 1; i < n; i++) {
            if (up) {
                if (i1 == 1) {
                    i2++;
                    up = !up;
                    continue;
                }
                i1--;
                i2++;
            } else {
                if (i2 == 1) {
                    i1++;
                    up = !up;
                    continue;
                }
                i1++;
                i2--;
            }
        }
        System.out.println(i1 + "/" + i2);
    }
}
