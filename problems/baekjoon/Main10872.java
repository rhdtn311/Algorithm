package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));

    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return factorial(n - 1) * n;
    }
}
