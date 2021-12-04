package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3085 {

    static int N;

    static String[][] arr;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i < N-1) {
                    swap(i, j, i + 1, j);
                    int width1 = checkWidth(i);
                    int width2 = checkWidth(i + 1);
                    int height = checkHeight(i);
                    max = Math.max(max, Math.max(width1, Math.max(height, width2)));
                    swap(i, j, i + 1, j);
                }

                if (j < N-1) {
                    swap(i, j, i, j + 1);
                    int height1 = checkHeight(j);
                    int height2 = checkHeight(j + 1);
                    int width = checkWidth(j);
                    max = Math.max(max, Math.max(height1, Math.max(height2, width)));
                    swap(i, j, i, j + 1);
                }
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {

        String temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static int checkWidth(int height) {

        int max = 1;
        int count = 1;
        String prev = arr[height][0];
        for (int i = 1; i < N; i++) {
            if (prev.equals(arr[height][i])) {
                count++;
                max = Math.max(max, count);
            } else {
                prev = arr[height][i];
                count = 1;
            }
        }

        return max;
    }

    static int checkHeight(int width) {

        int max = 1;
        int count = 1;
        String prev = arr[0][width];
        for (int i = 1; i < N; i++) {
            if (prev.equals(arr[i][width])) {
                count++;
                max = Math.max(max, count);
            } else {
                prev = arr[i][width];
                count = 1;
            }
        }
        return max;
    }
}
