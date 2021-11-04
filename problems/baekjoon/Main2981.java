package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2981 {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int num = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            num = gcd(num, arr[i] - arr[i-1]);
        }

        cd(num);

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

    static void cd(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sb.append(i).append(" ");
            }
        }
    }
}
