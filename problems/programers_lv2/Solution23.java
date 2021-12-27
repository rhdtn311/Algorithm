package programers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution23 {

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};
    static boolean[][] visited;

    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];
        bfs(0, 0, maps);

        int n = maps.length - 1;
        int m = maps[0].length - 1;
        return maps[n][m] == 1 ? -1 : maps[n][m];

    }

    public void bfs(int x, int y, int[][] maps) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            int nowY = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < maps.length && nextY < maps[0].length) {

                    if (visited[nextX][nextY]) {
                        continue;
                    }


                    if (maps[nextX][nextY] == 0) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    maps[nextX][nextY] = maps[nowX][nowY] + 1;

                    queue.add(nextX);
                    queue.add(nextY);
                }
            }
        }
    }
}
