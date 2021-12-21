package programers_lv2;

import java.util.Arrays;

public class Solution15version2 {

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    static int[] result = new int[5];

    public static void main(String[] args) {
        int[] solution = solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(String[][] places) {

        result = new int[5];
        Arrays.fill(result, 1);

        int index = 0;
        for (String[] place : places) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        visited[i][j] = true;
                        dfs(i, j, 0, visited, place, index);
                    }
                }
            }
            index++;
        }

        return result;

    }

    public static void dfs(int x, int y, int depth, boolean[][] visited, String[] place, int index) {

        if (depth > 2) {
            return;
        }

        if (depth > 0 && depth <= 2) {
            if (place[x].charAt(y) == 'P') {
                result[index] = 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5) {
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (place[nextX].charAt(nextY) == 'X') {
                    continue;
                }

                visited[nextX][nextY] = true;
                dfs(nextX, nextY, depth + 1, visited, place, index);
                visited[nextX][nextY] = false;

            }
        }
    }
}
