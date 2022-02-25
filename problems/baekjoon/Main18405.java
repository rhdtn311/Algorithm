package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main18405 {

    static int N, K, S, X, Y;
    static int[][] arr;
    static int[] nx = new int[]{-1, 1, 0, 0};
    static int[] ny = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        Virus[][] testTube = new Virus[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                testTube[i][j] = new Virus(i, j, Integer.parseInt(input[j]), 0);
            }
        }

        String[] SXY = br.readLine().split(" ");
        S = Integer.parseInt(SXY[0]);
        X = Integer.parseInt(SXY[1]);
        Y = Integer.parseInt(SXY[2]);

        Queue<Virus> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (testTube[i][j].type != 0) {
                    queue.add(new Virus(i, j, testTube[i][j].type, testTube[i][j].time));
                }
            }
        }

        bfs(queue, testTube);

        System.out.println(Arrays.deepToString(testTube));

        System.out.println(testTube[X-1][Y-1].type);
    }

    static void bfs(Queue<Virus> queue, Virus[][] testTube) {

        while (!queue.isEmpty()) {
            Virus now = queue.poll();

            if (now.time >= S) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int nextX = now.x + nx[i];
                int nextY = now.y + ny[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                Virus next = new Virus(nextX, nextY, now.type, now.time + 1);
                if (testTube[nextX][nextY].type == 0) {
                    testTube[nextX][nextY] = next;
                    queue.add(next);
                } else {
                    if (testTube[nextX][nextY].time == 0) {
                        continue;
                    } else {
                        if (now.time < testTube[nextX][nextY].time) {
                            if (now.type < testTube[nextX][nextY].type) {
                                testTube[nextX][nextY] = next;
                                queue.add(next);
                            }
                        }
                    }
                }
            }
        }
    }

    static class Virus {
        int x;
        int y;
        int type;
        int time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "type=" + type +
                    ", time=" + time +
                    '}';
        }
    }
}
