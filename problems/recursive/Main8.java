package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main8 {

    static int answer = 0;
    static int[] dis = new int[]{-1, 1, 5};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] se = br.readLine().split(" ");
        int s = Integer.parseInt(se[0]);
        int e = Integer.parseInt(se[1]);

        visited = new boolean[10001];

        bfs(s, e);

        System.out.println(answer);
    }

    static void bfs(int s, int e) {
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(0, s));
        visited[s] = true;

        outer : while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nextVal = now.val + dis[i];
                if (nextVal == e) {
                    answer = now.count + 1;
                    break outer;
                }

                if (nextVal >= 0 && nextVal <= 10000 && !visited[nextVal]) {
                    Position next = new Position(now.count + 1, nextVal);
                    visited[nextVal] = true;

                    queue.offer(next);
                }
            }
        }
    }

    static class Position {
        int count;
        int val;

        public Position(int count, int val) {
            this.count = count;
            this.val = val;
        }
    }
}
