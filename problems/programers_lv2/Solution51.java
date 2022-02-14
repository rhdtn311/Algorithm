package programers_lv2;

import java.util.Arrays;

public class Solution51 {

    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

    public static int[] solution(int[][] arr) {
        dfs(0,0,arr.length, arr);

        return new int[]{zeroCount, oneCount};
    }

    public static void dfs(int x, int y, int size, int[][] arr) {

        if (size == 1) {
            if (arr[x][y] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }

            return;
        }

        boolean allSame = true;
        outer:
        for (int i = x; i < x + size; i++) {
            int value = arr[x][y];
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    allSame = false;
                    break outer;
                }
            }
        }

        System.out.println("allSame : " + allSame);
        if (allSame) {
            System.out.println("x : " + x + "  y : " + y );
            if (arr[x][y] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int n = size / 2;
        for (int i = x; i < x + size; i += n) {
            for (int j = y; j < y + size; j += n) {
                dfs(i, j, n, arr);
            }
        }
    }
}
