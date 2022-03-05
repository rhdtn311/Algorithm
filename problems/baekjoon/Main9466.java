package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9466 {

    static int hasTeam;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            boolean[] done = new boolean[N + 1];
            hasTeam = 0;

            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(input[i - 1]);
            }

            for (int i = 1; i <= N; i++) {
                if (!done[i]) {
                    dfs(i, visited, done);
                }
            }

            System.out.println(N - hasTeam);
        }
    }

    static void dfs(int now, boolean[] visited, boolean[] done) {

        if (done[now]) {
            return;
        }

        if (visited[now]) {
            if (!done[now]) {
                hasTeam++;
                done[now] = true;
            }
        }

        visited[now] = true;
        dfs(arr[now], visited, done);
        done[now] = true;
        visited[now] = false;
    }
}
