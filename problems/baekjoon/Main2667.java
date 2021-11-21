package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main2667 {

    static int N;

    static int[][] map;

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> houses = new ArrayList<>();

        int danji = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] == 1) {
                    int count = dfs(i, j, 0);
                    houses.add(count);
                }
            }
        }

        Collections.sort(houses);

        sb.append(houses.size()).append('\n');
        for (Integer house : houses) {
            sb.append(house).append('\n');
        }

        System.out.println(sb);
    }

    static int dfs(int x, int y, int count) {

        ++count;

        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {

            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {

                if (map[nextX][nextY] == 0) {
                    continue;
                }

                count = dfs(nextX, nextY, count);
            }
        }

        return count;
    }
}
