package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int gcd = gcd(arr[0], arr[i]);
            sb.append(arr[0] / gcd).append('/').append(arr[i] / gcd).append('\n');
        }

        System.out.println(sb);
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
