package programers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution15 {

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    static int[] result;

    public static int[] solution(String[][] places) {


        result = new int[places.length];

        int index = 0;
        outer : for (String[] place : places) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        boolean bfs = bfs(place, i, j, new boolean[5][5]);

                        if (bfs) {
                            result[index++] = 0;
                            continue outer;
                        }
                    }
                }
            }
            result[index++] = 1;
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    static boolean bfs(String[] place, int x, int y, boolean[][] visited) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();

        queue.add(x);
        queue.add(y);

        depth.add(0);

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int nowX = queue.poll();
            int nowY = queue.poll();

            int nowDepth = depth.poll();
            if (nowDepth > 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + nx[i];
                int nextY = nowY + ny[i];

                if (nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5) {

                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    if (place[nextX].charAt(nextY) == 'X') {
                        continue;
                    }

                    if (place[nextX].charAt(nextY) == 'P') {
                        return true;
                    }

                    visited[nextX][nextY] = true;
                    queue.add(nextX);
                    queue.add(nextY);

                    depth.add(nowDepth + 1);

                }
            }
        }

        return false;
    }

}
