package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main7562 {

    static int I;

    static int[][] map;
    static boolean[][] visited;

    static int[] nx = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
    static int[] ny = new int[]{1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new boolean[I][I];

            String[] start = br.readLine().split(" ");
            String[] end = br.readLine().split(" ");

            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);

            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);

            System.out.println(bfs(startX, startY, endX, endY));

        }
    }

    static int bfs(int x, int y, int endX, int endY) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            int nowY = queue.poll();

            for (int i = 0; i < 8; i++) {

                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < I && nextY < I) {

                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    map[nextX][nextY] = map[nowX][nowY] + 1;

                    visited[nextX][nextY] = true;

                    queue.add(nextX);
                    queue.add(nextY);

                    if (nextX == endX && nextY == endY) {
                        return map[nextX][nextY];
                    }
                }

            }
        }
        return 0;
    }
}
