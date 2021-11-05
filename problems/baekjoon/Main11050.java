package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        System.out.println(factorial(n) / (factorial(k) * (factorial(n - k))));
    }

    static int factorial(int n) {
        int number = 1;
        for (int i = 1; i <= n; i++) {
            number = number * i;
        }

        return number;
    }
}
