package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2206 {

    static int N;
    static int M;

    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(0,0);
        System.out.println(-1);

    }

    static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y, 1, 0));

        visited[x][y][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                System.out.println(now.count);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                Node next = new Node(now.x + nx[i], now.y + ny[i], now.count + 1, now.wall);

                if (next.x >= 0 && next.y >= 0 && next.x < N && next.y < M) {

                    if (map[next.x][next.y] == 1) {

                        if (next.wall == 1) {
                            continue;
                        }

                        if (visited[next.x][next.y][1] == 1) {
                            continue;
                        }

                        next.wall = 1;
                        visited[next.x][next.y][1] = 1;
                        queue.add(next);

                    } else {

                        if (next.wall == 1) {
                            if (visited[next.x][next.y][1] == 1) {
                                continue;
                            }

                            visited[next.x][next.y][1] = 1;

                        } else {
                            if (visited[next.x][next.y][0] == 1) {
                                continue;
                            }
                            visited[next.x][next.y][0] = 1;
                        }

                        queue.add(next);

                    }
                }
            }
        }
    }

    static class Node{
        private int x;
        private int y;
        private int count;
        private int wall;

        public Node(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", wall=" + wall +
                    '}';
        }
    }
}
