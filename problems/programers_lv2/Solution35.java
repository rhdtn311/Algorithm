package programers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution35 {

    static int count = 0;

    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean[][] squares = new boolean[m][n];
            play(map, squares, m, n);
            int now = remove(squares, map);
            if (now == 0) {
                break;
            }
            change(map);

            count += now;
        }

        return count;
    }

    public static void play(char[][] map, boolean[][] squares, int m, int n) {

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char now = map[i][j];
                if (now == 'x') {
                    continue;
                }
                if (now == map[i + 1][j] && now == map[i][j + 1] && now == map[i + 1][j + 1]) {
                    squares[i][j] = true;
                    squares[i + 1][j] = true;
                    squares[i][j + 1] = true;
                    squares[i + 1][j + 1] = true;
                }
            }
        }
    }

    static int remove(boolean[][] squares, char[][] map) {

        int count = 0;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j]) {
                    count++;
                    map[i][j] = 'x';
                }
            }
        }

        return count;
    }

    static void change(char[][] map) {
        for (int i = map.length - 1; i > 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'x') {
                    int nextX = i;
                    int nowX = i;

                    while (nowX > 0) {
                        nowX--;
                        if (map[nowX][j] != 'x') {
                            nextX = nowX;
                            break;
                        }
                    }

                    char temp = map[i][j];
                    map[i][j] = map[nextX][j];
                    map[nextX][j] = temp;
                }
            }
        }
    }
}
