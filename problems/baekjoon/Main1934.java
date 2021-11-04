package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);

            int gcd = gcd(n1, n2);
            System.out.println(n1 * n2 / gcd);
        }
    }

    static int gcd(int n1, int n2) {
        while (n2 != 0) {
            int r = n1 % n2;
            n1 = n2;
            n2 = r;
        }

        return n1;
    }
}
