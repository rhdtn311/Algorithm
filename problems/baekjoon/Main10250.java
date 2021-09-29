package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int H = Integer.parseInt(s[0]);
            int W = Integer.parseInt(s[1]);
            int N = Integer.parseInt(s[2]);

            String first = String.valueOf(N % H == 0 ? H : N % H);
            String second = String.valueOf(N % H == 0 ? N / H : N / H + 1);
            if (second.length() == 1) {
                second = "0" + second;
            }
            System.out.println(first + second);
        }
    }
}
