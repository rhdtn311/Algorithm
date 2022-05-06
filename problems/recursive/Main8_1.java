package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main8_1 {

    static int[] dis = new int[]{-1, 1, 5};
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] se = br.readLine().split(" ");
        int s = Integer.parseInt(se[0]);
        int e = Integer.parseInt(se[1]);

        System.out.println(bfs(s, e));
    }

    static int bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int L = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer now = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = now + dis[j];
                    if (next == e) return L + 1;
                    if (next >= 0 && next <= 10000 && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            L++;
        }

        return 0;
    }
}
