package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1018 {
    static boolean[][] chess;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        chess = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i][j] = str.charAt(j) == 'W';
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int result = compareChess(i, j);
                min = Math.min(result, min);
            }
        }
        System.out.println(min);
    }

    static int compareChess(int x, int y) {
        boolean color = true; // W = true, B = false
        int count = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (chess[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }

        return Math.min(count, 64 - count);
    }
}
