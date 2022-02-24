package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main14502 {

    static int N, M;
    static int[][] arr;
    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] newArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        dfs(0);

        System.out.println(max);
    }

    static void bfs(int x, int y, int[][] newArr) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.add(x);
        yQueue.add(y);
        while (!xQueue.isEmpty()) {
            Integer nowX = xQueue.poll();
            Integer nowY = yQueue.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (newArr[nextX][nextY] == 0) {
                    newArr[nextX][nextY] = 2;

                    xQueue.add(nextX);
                    yQueue.add(nextY);
                }
            }
        }
    }

    static void check(int[][] newArr) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newArr[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }

    static void dfs(int count) {

        if (count == 3) {
            int[][] newArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    newArr[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (newArr[i][j] == 2) {
                        bfs(i, j, newArr);
                    }
                }
            }

            check(newArr);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

}
