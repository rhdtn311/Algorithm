package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2609version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);

        System.out.println(gcd(n1, n2));
        System.out.println(lcm(n1, n2));
    }

    static int gcd(int n1, int n2) {
        while (n2 != 0) {
            int r = n1 % n2;

            n1 = n2;
            n2 = r;
        }

        return n1;
    }

    static int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }
}
