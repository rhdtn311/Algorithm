package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {

    static String[][] arr;

    static int[] nx = new int[]{-1, 0, 1, 0};
    static int[] ny = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j];
            }
        }

        int count = 0;
        int redGreenCount = 0;
        boolean[][] visited = new boolean[N][N];
        boolean[][] redGreenVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, visited, false, arr[i][j]);
                    count++;
                }

                if (!redGreenVisited[i][j]) {
                    dfs(i, j, redGreenVisited, true, arr[i][j]);
                    redGreenCount++;
                }
            }
        }

        System.out.println(count + " " + redGreenCount);
    }

    static void dfs(int x, int y, boolean[][] visited, boolean isRedGreen, String color) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (isRedGreen) {
                if (color.equals("B")) {
                    if (!arr[nextX][nextY].equals("B")) {
                        continue;
                    }
                } else {
                    if (arr[nextX][nextY].equals("B")) {
                        continue;
                    }
                }
            } else {
                if (color.equals("R")) {
                    if (!arr[nextX][nextY].equals("R")) {
                        continue;
                    }
                } else if (color.equals("G")) {
                    if (!arr[nextX][nextY].equals("G")) {
                        continue;
                    }
                } else {
                    if (!arr[nextX][nextY].equals("B")) {
                        continue;
                    }
                }
            }

            dfs(nextX, nextY, visited, isRedGreen, color);
        }
    }
}
