package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main11 {
    static int[][] arr = new int[7][7];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[][] visited = new boolean[7][7];

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(bfs(new Node(0, 0)));
    }

    static int bfs(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node now = queue.poll();

                visited[now.x][now.y] = true;

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && arr[nx][ny] == 0 && !visited[nx][ny]) {
                        if (nx == 6 && ny == 6) return L + 1;

                        queue.add(new Node(nx, ny));
                    }
                }
            }
            L++;
        }

        return -1;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
