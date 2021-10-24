package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main2580 {

    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        sudoku(0, 0);

    }

    public static void sudoku(int height, int width) {

        if (width == 9) {
            sudoku(height + 1, 0);
            return;
        }

        if (height == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[height][width] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(height, width, i)) {
                    arr[height][width] = i;
                    sudoku(height, width+1);
                }
            }

            arr[height][width] = 0;
            return;
        }

        sudoku(height, width+1);
    }

    public static boolean isPossible(int height, int width, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[height][i] == value) {
                return false;
            }

            if (arr[i][width] == value) {
                return false;
            }
        }

        int setHeight = height/3*3;
        int setWidth = width/3*3;
        for (int i = setHeight; i < setHeight+3; i++) {
            for (int j = setWidth; j < setWidth+3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
