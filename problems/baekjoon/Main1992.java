package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        quadTree(0, 0, N);

        System.out.println(sb);


    }

    static void quadTree(int x, int y, int size) {

        if (check(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newSize = size / 2;
        int newX = x + newSize;
        int newY = y + newSize;

        sb.append('(');
        quadTree(x, y, newSize);
        quadTree(x, newY, newSize);
        quadTree(newX, y, newSize);
        quadTree(newX, newY, newSize);
        sb.append(')');

    }

    static boolean check(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}
