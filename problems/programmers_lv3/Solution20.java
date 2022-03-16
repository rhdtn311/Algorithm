package programmers_lv3;

import java.util.Arrays;

public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean solution = solution20.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        System.out.println(solution);
    }
    public boolean solution(int[][] key, int[][] lock) {

        int M = key.length;
        int N = lock.length;
        int[][] expandLock = new int[N + (2 * M)][N + (2 * M)];
        for (int i = M; i < expandLock.length - M; i++) {
            for (int j = M; j < expandLock.length - M; j++) {
                expandLock[i][j] = lock[i - M][j - M];
            }
        }

        for (int k = 0; k < 4; k++) {
            boolean result = false;
            for (int i = 0; i < expandLock.length - M; i++) {
                for (int j = 0; j < expandLock.length - M; j++) {
                    result = check(i, j, key, expandLock);
                    if (result) {
                        System.out.println("x : " + i + " y : " + j);
                        System.out.println(Arrays.deepToString(expandLock));
                        System.out.println(Arrays.deepToString(key));
                    }
                    if (result) {
                        return true;
                    }
                }
            }

            key = rotate(key);
        }

        return false;
    }

    public boolean check(int x, int y, int[][] key, int[][] lock) {

        for (int i = x; i < x + key.length; i++) {
            for (int j = y; j < y + key.length; j++) {
                lock[i][j] += key[i - x][j - y];
            }
        }

        boolean result = true;
        int M = key.length;
        for (int i = M; i < lock.length - M; i++) {
            for (int j = M; j < lock.length - M; j++) {
                if (lock[i][j] != 1) {
                     result = false;
                }
            }
        }

        for (int i = x; i < x + key.length; i++) {
            for (int j = y; j < y + key.length; j++) {
                lock[i][j] -= key[i - x][j - y];
            }
        }

        return result;
    }

    public int[][] rotate(int[][] key) {

        int[][] rotateKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotateKey[i][j] = key[key.length - 1 -j][i];
            }
        }

        return rotateKey;
    }
}
