package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1074 {

    static int value = 0;
    static int r, c;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nrc = br.readLine().split(" ");
        int n = (int) Math.pow(2, Integer.parseInt(nrc[0]));

        r = Integer.parseInt(nrc[1]);
        c = Integer.parseInt(nrc[2]);
        solve(0, 0, n);

    }

    static void solve(int x, int y, int size) {
        if (size == 1) {
            System.out.println(answer);
            return;
        }

        int newSize = size / 2;
        if (r < x + newSize && c < y + newSize) {
            solve(x, y, newSize);
        } else if (r < x + newSize && c >= y + newSize) {
            answer += (size * size / 4);
            solve(x, y + newSize, newSize);
        } else if (r >= x + newSize && c < y + newSize) {
            answer += (size * size / 2);
            solve(x + newSize, y, newSize);
        } else {
            answer += (size * size / 4) * 3;
            solve(x + newSize, y + newSize, newSize);
        }
    }
}
