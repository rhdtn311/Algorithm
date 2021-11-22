    package baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.Queue;

    public class Main7569 {

        static int M;
        static int N;
        static int H;

        static int[][][] map;
        static boolean[][][] visited;

        static int[] nx = new int[]{-1, 1, 0, 0, 0, 0};
        static int[] ny = new int[]{0, 0, -1, 1, 0, 0};
        static int[] nz = new int[]{0, 0, 0, 0, -1, 1};

        static Queue<Integer> queue = new LinkedList<>();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] MNH = br.readLine().split(" ");
            M = Integer.parseInt(MNH[0]);
            N = Integer.parseInt(MNH[1]);
            H = Integer.parseInt(MNH[2]);

            map = new int[H][N][M];
            visited = new boolean[H][N][M];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    String[] input = br.readLine().split(" ");
                    for (int k = 0; k < M; k++) {
                        map[i][j][k] = Integer.parseInt(input[k]);
                        if (map[i][j][k] == 1) {
                            queue.add(i);
                            queue.add(j);
                            queue.add(k);

                            visited[i][j][k] = true;
                        }
                    }
                }
            }

            bfs(queue);

            int max = -1;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (max < map[i][j][k]) {
                            max = map[i][j][k];
                        }

                        if (map[i][j][k] == 0) {
                            System.out.println(-1);
                            System.exit(0);
                        }
                    }
                }
            }

            System.out.println(max - 1);

        }

        static void bfs(Queue<Integer> queue) {

            while (!queue.isEmpty()) {
                int nowZ = queue.poll();
                int nowX = queue.poll();
                int nowY = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nextZ = nowZ + nz[i];
                    int nextX = nowX + nx[i];
                    int nextY = nowY + ny[i];

                    if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < N && nextY < M && nextZ < H) {

                        if (visited[nextZ][nextX][nextY]) {
                            continue;
                        }

                        if (map[nextZ][nextX][nextY] == -1) {
                            continue;
                        }

                        map[nextZ][nextX][nextY] = map[nowZ][nowX][nowY] + 1;

                        visited[nextZ][nextX][nextY] = true;

                        queue.add(nextZ);
                        queue.add(nextX);
                        queue.add(nextY);
                    }
                }
            }

        }
    }
