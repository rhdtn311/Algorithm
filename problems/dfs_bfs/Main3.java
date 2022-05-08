package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    static int N;
    static int M;

    static int[] scores;
    static int[] times;

    static int answer;

    static void dfs(int depth, int score, int time) {

        if (time > M) {
            return;
        }

        if (depth == N) {
            answer = Math.max(answer, score);
            return;
        }

        dfs(depth + 1, score + scores[depth], time + times[depth]);
        dfs(depth + 1, score, time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        scores = new int[N];
        times = new int[N];

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            scores[i] = Integer.parseInt(st[0]);
            times[i] = Integer.parseInt(st[1]);
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }
}
