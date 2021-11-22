package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1697 {

    static int N;
    static int K;

    static Queue<Integer> queue = new LinkedList<>();

    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]); // 출발
        K = Integer.parseInt(NK[1]); // 도착

        map = new int[1000001];
        visited = new boolean[1000001];

        queue.add(N);
        visited[N] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now + 1 < 1000001 && !visited[now + 1]) {
                visited[now + 1] = true;
                queue.add(now + 1);
                map[now + 1] = map[now] + 1;
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                visited[now - 1] = true;
                queue.add(now - 1);
                map[now - 1] = map[now] + 1;
            }

            if (now * 2 < 1000001 && !visited[now * 2]) {
                visited[now * 2] = true;
                queue.add(now * 2);
                map[now * 2] = map[now] + 1;
            }
        }

        System.out.println(map[K]);
    }
}
