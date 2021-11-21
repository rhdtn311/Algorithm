package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667version2 {

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

        ArrayList<Integer> houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j] != 0) {
                    houses.add(bfs(i, j, 0));
                }
            }
        }

        Collections.sort(houses);

        StringBuilder sb = new StringBuilder();
        sb.append(houses.size()).append('\n');

        for (Integer house : houses) {
            sb.append(house).append('\n');
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y, int count) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        map[x][y] = 0;
        while (!queue.isEmpty()) {

            int nowX = queue.poll();
            int nowY = queue.poll();

            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {

                    if (map[nextX][nextY] == 0) {
                        continue;
                    }

                    queue.add(nextX);
                    queue.add(nextY);

                    map[nextX][nextY] = 0;
                }
            }
        }

        return count;
    }
}
