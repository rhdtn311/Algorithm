package programers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public static int[] solution(int m, int n, int[][] picture) {

        boolean[][] visited = new boolean[m][n];

        int max = Integer.MIN_VALUE;

        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int result = bfs(i, j, picture[i][j], n, m, picture, visited);
                    max = Math.max(result, max);
                    area++;
                }
            }
        }

        return new int[]{area, max};
    }

    public static int bfs(int x, int y, int color, int n, int m, int[][] picture, boolean[][] visited) {

        int[] nx = new int[]{0, 0, -1, 1};
        int[] ny = new int[]{-1, 1, 0, 0};

        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Integer nowX = queue.poll();
            Integer nowY = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {

                    if (picture[nextX][nextY] != color || visited[nextX][nextY]) {
                        continue;
                    }

                    visited[nextX][nextY] = true;

                    count++;

                    queue.add(nextX);
                    queue.add(nextY);
                }
            }
        }

        return count;

    }
}
