package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main11_1 {

    static int[][] arr = new int[7][7];
    static int[][] temp = new int[7][7];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        arr[0][0] = 1;
        bfs(new Node(0, 0));

        System.out.println(temp[6][6] == 0 ? -1 : temp[6][6]);
    }

    static void bfs(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    temp[nx][ny] = temp[now.x][now.y] + 1;

                    queue.offer(new Node(nx, ny));
                }
            }
        }
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
