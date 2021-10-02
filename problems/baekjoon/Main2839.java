package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = n / 5;
        for (int i = m; i >= 0; i--) {
            if ((n - (5 * i)) % 3 == 0) {
                m = i;
                break;
            }
            m = Integer.MAX_VALUE;
        }

        int count = 0;
        if (m == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            count += m;
            count += (n - (5 * m)) / 3;
            System.out.println(count);
        }
    }
}
