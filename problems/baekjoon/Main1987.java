package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main1987 {

    static int R;
    static int C;
    static String[][] arr;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        arr = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = input[j];
            }
        }

        boolean[][] visited = new boolean[R][C];
        HashSet<String> set = new HashSet<>();
        visited[0][0] = true;
        set.add(arr[0][0]);
        dfs(0, 0, visited, set);

        System.out.println(max);

    }

    static void dfs(int x, int y, boolean[][] visited, HashSet<String> set) {

        for (int i = 0; i < 4; i++) {

            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (!set.contains(arr[nextX][nextY])) {
                visited[nextX][nextY] = true;
                set.add(arr[nextX][nextY]);
                max = Math.max(max, set.size());
                dfs(nextX, nextY, visited, set);
                set.remove(arr[nextX][nextY]);
                visited[nextX][nextY] = false;
            }
        }
    }
}
